package com.ortiz.com.ortiz.business;

import com.ortiz.dto.ContextFlowDTO;
import com.ortiz.dto.DataDTO;
import com.ortiz.grpc.services.DataServiceGrpc;
import com.ortiz.grpc.services.Person;
import com.ortiz.grpc.services.vfs.ValidationField;
import com.ortiz.grpc.services.vfs.ValidationFields;
import com.ortiz.grpc.services.vfs.ValidationFieldsServiceGrpc;
import com.ortiz.poc.dto.PersonDTO;
import com.ortiz.poc.dto.ValidationFieldDTO;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import static com.ortiz.com.ortiz.business.config.Constants.TOPIC_EXCHANGE_NAME;
import static com.ortiz.poc.commons.FieldUtils.getStringValue;
import static com.ortiz.poc.commons.GRPCMapper.*;
import static io.reactivex.rxjava3.core.Single.just;

@Service
@Slf4j
public class FlowableFactory {

    private static final Integer MAX_RETRIES = 2;

    @GrpcClient("data-service")
    private DataServiceGrpc.DataServiceBlockingStub dataServiceStub;

    @GrpcClient("validation-fields-service")
    private ValidationFieldsServiceGrpc.ValidationFieldsServiceBlockingStub validationFieldsServiceStub;

    @Autowired
    private DataFilteringService dataFilteringService;

    @Value("${application.data-service.url}")
    private String urlDataService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public Single<DataDTO> getPersistenceFlow(AtomicReference<ContextFlowDTO> atomicReference) {
        return just(atomicReference)
                .map(validateValidationFields())
                // retry when network errors
                .retry(MAX_RETRIES, retryOnlyWhenNetworkError)
                .map(filterPersonData())
                .map(validatePersonData())
                // retry when network errors
                .retry(MAX_RETRIES, retryOnlyWhenNetworkError)
                .map(persistPersonData())
                // retry when network errors
                .retry(MAX_RETRIES, retryOnlyWhenNetworkError)
                .map(persistValidationFields())
                // retry when network errors
                .retry(MAX_RETRIES, retryOnlyWhenNetworkError)
                .map(transformResult(StateEnum.DONE))
                .onErrorResumeNext(throwable -> {
                    log.error("Error ocurr. We will try revert...");
                    return getUndoFlowableByState(atomicReference);
                });
    }

    public Single<DataDTO> getUndoFlowableByState(AtomicReference<ContextFlowDTO> atomicReference) {
        Single<AtomicReference<ContextFlowDTO>> single = just(atomicReference);
        StateEnum stateEnum = atomicReference.get().getStateEnum();
        switch (stateEnum) {
            case DO_PERSIST_PERSON:
                single = single.map(undoPersistPersonData());
                break;
            case DO_PERSIST_VALIDATED_FIELDS:
                single = single.map(undoPersistValidationFields()).map(undoPersistPersonData());
                break;
        }
        return single
                .map(transformResult(StateEnum.UNDONE))
                .onErrorResumeNext(throwable -> {
                    ContextFlowDTO contextFlow = atomicReference.get();
                    log.error("Error to undo operations. Please try later.", throwable);
                    // sending to dlq
                    rabbitTemplate.convertAndSend(TOPIC_EXCHANGE_NAME, "flow-with-error", atomicReference.get());
                    return Single.just(atomicReference).map(transformResult(contextFlow.getStateEnum()));
                });
    }


    public Function<AtomicReference<ContextFlowDTO>, AtomicReference<ContextFlowDTO>> validateValidationFields() {
        return (AtomicReference<ContextFlowDTO> atomicReference) -> {
            ContextFlowDTO contextFlow = atomicReference.get();
            contextFlow.setStateEnum(StateEnum.DO_VALIDATE_FIELDS);
            ValidationFields validationFieldsRequest = toValidationFieldsGRPC(contextFlow.getData().getValidationFields());
            ValidationFields validatedFields = validationFieldsServiceStub.validateFields(validationFieldsRequest);
            List<ValidationFieldDTO> validatedFieldsDTO = toValidationFieldsDTO(validatedFields);
            contextFlow.setValidatedFields(validatedFieldsDTO);

            atomicReference.set(contextFlow);
            return atomicReference;
        };
    }

    public Function<AtomicReference<ContextFlowDTO>, AtomicReference<ContextFlowDTO>> filterPersonData() {
        return (AtomicReference<ContextFlowDTO> atomicReference) -> {
            ContextFlowDTO contextFlow = atomicReference.get();
            List<ValidationFieldDTO> invalidFields = contextFlow.getValidatedFields().stream().filter(validationFieldDTO -> !validationFieldDTO.getServerValidated()).collect(Collectors.toList());
            PersonDTO personValidateFieldsFiltered = dataFilteringService.filterData(contextFlow.getData().getPerson(), invalidFields);
            contextFlow.setPersonValidateFieldsFiltered(personValidateFieldsFiltered);

            atomicReference.set(contextFlow);
            return atomicReference;
        };
    }

    public Function<AtomicReference<ContextFlowDTO>, AtomicReference<ContextFlowDTO>> validatePersonData() {
        return (AtomicReference<ContextFlowDTO> atomicReference) -> {
            ContextFlowDTO contextFlow = atomicReference.get();
            contextFlow.setStateEnum(StateEnum.DO_VALIDATE_PERSON_DATA);
            Person person = toPersonGRPC(contextFlow.getPersonValidateFieldsFiltered());
            Person personValidated = dataServiceStub.validateSavePerson(person);
            PersonDTO personValidatedDTO = toPersonDTO(personValidated);
            contextFlow.setPersonValidated(personValidatedDTO);

            atomicReference.set(contextFlow);
            return atomicReference;
        };
    }

    public Function<AtomicReference<ContextFlowDTO>, AtomicReference<ContextFlowDTO>> persistPersonData() {
        return (AtomicReference<ContextFlowDTO> atomicReference) -> {
            ContextFlowDTO contextFlow = atomicReference.get();
            contextFlow.setStateEnum(StateEnum.DO_PERSIST_PERSON);
            Person personValidated = toPersonGRPC(contextFlow.getPersonValidated());
            Person personPersisted = dataServiceStub.savePerson(personValidated);
            PersonDTO personPersistedDTO = toPersonDTO(personPersisted);
            contextFlow.setPersonPersisted(personPersistedDTO);

            atomicReference.set(contextFlow);
            return atomicReference;
        };
    }

    public Function<AtomicReference<ContextFlowDTO>, AtomicReference<ContextFlowDTO>> undoPersistPersonData() {
        return (AtomicReference<ContextFlowDTO> atomicReference) -> {

//            if (true) {
//                throw new RuntimeException("Testing DLQ");
//            }

            log.info("Undoing persisted person data...");
            ContextFlowDTO contextFlow = atomicReference.get();
            contextFlow.setStateEnum(StateEnum.UNDO_PERSIST_PERSON);

            if (contextFlow.getPersonPersisted() == null) {
                return atomicReference;
            }

            Person personPersisted = toPersonGRPC(contextFlow.getPersonPersisted());
            dataServiceStub.undoSavePerson(personPersisted);
            PersonDTO personPersistedDTO = toPersonDTO(personPersisted);
            contextFlow.setPersonPersisted(personPersistedDTO);

            atomicReference.set(contextFlow);
            return atomicReference;
        };
    }

    public Function<AtomicReference<ContextFlowDTO>, AtomicReference<ContextFlowDTO>> persistValidationFields() {
        return (AtomicReference<ContextFlowDTO> atomicReference) -> {
            ContextFlowDTO contextFlow = atomicReference.get();
            contextFlow.setStateEnum(StateEnum.DO_PERSIST_VALIDATED_FIELDS);

//            if (true) {
//                throw new RuntimeException("Testing rollback");
//            }

            List<ValidationFieldDTO> validFieldsDTO = contextFlow.getValidatedFields().stream().filter(validationFieldDTO -> validationFieldDTO.getServerValidated()).collect(Collectors.toList());
            // Updates valid fields with person id persited before
            List<ValidationField> validFieldsPersonIdUpdated = toValidationFieldsGRPC(validFieldsDTO).getVerifiedFieldsList().stream().map(validationField -> {
                return ValidationField.newBuilder(validationField).setPersonId(getStringValue(contextFlow.getPersonPersisted().getId())).build();
            }).collect(Collectors.toList());
            // persisted validated fields
            ValidationFields validatedFieldsPersisted = validationFieldsServiceStub.saveVerifiedFields(ValidationFields.newBuilder().addAllVerifiedFields(validFieldsPersonIdUpdated).build());
            List<ValidationFieldDTO> validationFieldsPersistedDTO = toValidationFieldsDTO(validatedFieldsPersisted);
            contextFlow.setValidationFieldsPersisted(validationFieldsPersistedDTO);

            atomicReference.set(contextFlow);
            return atomicReference;
        };
    }

    public Function<AtomicReference<ContextFlowDTO>, AtomicReference<ContextFlowDTO>> undoPersistValidationFields() {
        return (AtomicReference<ContextFlowDTO> atomicReference) -> {
            log.info("Undoing persisted validated person data...");
            ContextFlowDTO contextFlow = atomicReference.get();
            contextFlow.setStateEnum(StateEnum.DO_PERSIST_VALIDATED_FIELDS);

            if (CollectionUtils.isEmpty(contextFlow.getValidationFieldsPersisted())) {
                return atomicReference;
            }

            ValidationFields validationFields = toValidationFieldsGRPC(contextFlow.getValidationFieldsPersisted());
            // persisted validated fields
            ValidationFields validatedFieldsPersisted = validationFieldsServiceStub.undoSaveVerifiedFields(validationFields);
            List<ValidationFieldDTO> validationFieldsPersistedDTO = toValidationFieldsDTO(validatedFieldsPersisted);
            contextFlow.setValidationFieldsPersisted(validationFieldsPersistedDTO);

            atomicReference.set(contextFlow);
            return atomicReference;
        };
    }

    public Function<AtomicReference<ContextFlowDTO>, DataDTO> transformResult(final StateEnum stateEnum) {
        return (AtomicReference<ContextFlowDTO> atomicReference) -> {
            ContextFlowDTO contextFlow = atomicReference.get();
            contextFlow.setStateEnum(stateEnum);
            return DataDTO.builder().state(stateEnum).person(contextFlow.getPersonPersisted()).validationFields(contextFlow.getValidationFieldsPersisted()).build();
        };
    }

    private Predicate<Throwable> retryOnlyWhenNetworkError = (Throwable throwable) -> {
        if (throwable instanceof StatusRuntimeException) {
            return ((StatusRuntimeException) throwable).getStatus().equals(Status.ABORTED);
        } else if (throwable instanceof HttpClientErrorException) {
            return ((HttpClientErrorException) throwable).getStatusCode().is5xxServerError();
        }
        return false;
    };
}
