package com.ortiz.com.ortiz.business;

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
import io.reactivex.rxjava3.functions.Predicate;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.stream.Collectors;

import static com.ortiz.poc.commons.FieldUtils.getStringValue;
import static com.ortiz.poc.commons.GRPCMapper.*;

@Service
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

    @Value("${application.validation-fields-service.url}")
    private String urlValidationFieldsService;

    public Single<ContextFlow> getFlowableErrorByState(ContextFlow contextFlow) {
        return Single.just(contextFlow);
    }

    public Single<ContextFlow> validateValidationFields(Single<ContextFlow> single) {
        return single.map((ContextFlow contextFlow) -> {
            contextFlow.setStateEnum(StateEnum.DO_VALIDATE_FIELDS);
            ValidationFields validationFieldsRequest = toValidationFieldsGRPC(contextFlow.getData().getValidationFields());
            ValidationFields validatedFields = validationFieldsServiceStub.validateFields(validationFieldsRequest);
            List<ValidationFieldDTO> validatedFieldsDTO = toValidationFieldsDTO(validatedFields);
            contextFlow.setValidatedFields(validatedFieldsDTO);
            return contextFlow;
        })
        // retry when network errors
        .retry(MAX_RETRIES, retryOnlyWhenNetworkError);
    }

    public Single<ContextFlow> filterPersonData(Single<ContextFlow> single) {
        return single.map(contextFlow -> {
            List<ValidationFieldDTO> invalidFields = contextFlow.getValidatedFields().stream().filter(validationFieldDTO -> !validationFieldDTO.getServerValidated()).collect(Collectors.toList());
            PersonDTO personValidateFieldsFiltered = dataFilteringService.filterData(contextFlow.getData().getPerson(), invalidFields);
            contextFlow.setPersonValidateFieldsFiltered(personValidateFieldsFiltered);
            return contextFlow;
        });
    }

    public Single<ContextFlow> validatePersonData(Single<ContextFlow> single) {
        return single.map((ContextFlow contextFlow) -> {
            contextFlow.setStateEnum(StateEnum.DO_VALIDATE_PERSON_DATA);
            Person person = toPersonGRPC(contextFlow.getPersonValidateFieldsFiltered());
            Person personValidated = dataServiceStub.validateSavePerson(person);
            PersonDTO personValidatedDTO = toPersonDTO(personValidated);
            contextFlow.setPersonValidated(personValidatedDTO);
            return contextFlow;
        })
        // retry when network errors
        .retry(MAX_RETRIES, retryOnlyWhenNetworkError);
    }

    public Single<ContextFlow> persistPersonData(Single<ContextFlow> single) {
        return single.map((ContextFlow contextFlow) -> {
            contextFlow.setStateEnum(StateEnum.DO_PERSIST_PERSON);
            Person personValidated = toPersonGRPC(contextFlow.getPersonValidated());
            Person personPersisted = dataServiceStub.savePerson(personValidated);
            PersonDTO personPersistedDTO = toPersonDTO(personPersisted);
            contextFlow.setPersonPersisted(personPersistedDTO);
            return contextFlow;
        })
        // retry when network errors
        .retry(MAX_RETRIES, retryOnlyWhenNetworkError);
    }

    public Single<ContextFlow> persistValidationFields(Single<ContextFlow> single) {
        return single.map((ContextFlow contextFlow) -> {
            contextFlow.setStateEnum(StateEnum.DO_PERSIST_VALIDATED_FIELDS);
            List<ValidationFieldDTO> validFieldsDTO = contextFlow.getValidatedFields().stream().filter(validationFieldDTO -> validationFieldDTO.getServerValidated()).collect(Collectors.toList());
            // Updates valid fields with person id persited before
            List<ValidationField> validFieldsPersonIdUpdated = toValidationFieldsGRPC(validFieldsDTO).getVerifiedFieldsList().stream().map(validationField -> {
                return ValidationField.newBuilder(validationField).setPersonId(getStringValue(contextFlow.getPersonPersisted().getId())).build();
            }).collect(Collectors.toList());
            // persisted validated fields
            ValidationFields validatedFieldsPersisted = validationFieldsServiceStub.saveVerifiedFields(ValidationFields.newBuilder().addAllVerifiedFields(validFieldsPersonIdUpdated).build());
            List<ValidationFieldDTO> validationFieldsPersistedDTO = toValidationFieldsDTO(validatedFieldsPersisted);
            contextFlow.setValidationFieldsPersisted(validationFieldsPersistedDTO);
            return contextFlow;
        })
        // retry when network errors
        .retry(MAX_RETRIES, retryOnlyWhenNetworkError);
    }

    public Single<DataDTO> getResult(Single<ContextFlow> single) {
        return single.map((ContextFlow contextFlow) -> {
            return DataDTO.builder().person(contextFlow.getPersonPersisted()).validationFields(contextFlow.getValidationFieldsPersisted()).build();
        });
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
