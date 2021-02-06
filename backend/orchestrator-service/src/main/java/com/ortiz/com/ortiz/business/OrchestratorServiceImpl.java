package com.ortiz.com.ortiz.business;

import com.ortiz.dto.DataDTO;
import com.ortiz.grpc.services.DataServiceGrpc;
import com.ortiz.grpc.services.Person;
import com.ortiz.grpc.services.vfs.ValidationField;
import com.ortiz.grpc.services.vfs.ValidationFields;
import com.ortiz.grpc.services.vfs.ValidationFieldsServiceGrpc;
import com.ortiz.poc.dto.PersonDTO;
import com.ortiz.poc.dto.ValidationFieldDTO;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.ortiz.poc.commons.GRPCMapper.*;


@Service
@Slf4j
public class OrchestratorServiceImpl {

    @GrpcClient("data-service")
    private DataServiceGrpc.DataServiceBlockingStub dataServiceStub;

    @GrpcClient("validation-fields-service")
    private ValidationFieldsServiceGrpc.ValidationFieldsServiceBlockingStub validationFieldsServiceStub;

    @Autowired
    private DataFilteringService dataFilteringService;

    public DataDTO saveData(DataDTO dataDTO) {
        PersonDTO personDTO = dataDTO.getPerson();
        List<ValidationFieldDTO> verifiedFields = dataDTO.getValidationFields();

        ValidationFields validationFieldsRequest = toValidationFieldsGRPC(verifiedFields);
        ValidationFields valdationFieldsValidated = validationFieldsServiceStub.validateFields(validationFieldsRequest);

        List<ValidationField> valids = valdationFieldsValidated.getVerifiedFieldsList().stream().filter(verifiedField -> verifiedField.getServerValidated().getValue()).collect(Collectors.toList());
        List<ValidationField> invalids = valdationFieldsValidated.getVerifiedFieldsList().stream().filter(verifiedField -> !verifiedField.getServerValidated().getValue()).collect(Collectors.toList());
        List<ValidationFieldDTO> invalidFieldsDTO = invalids.stream().map(verifiedField -> toValidationFieldDTO(verifiedField)).collect(Collectors.toList());
        PersonDTO personValidatedDTO = dataFilteringService.filterData(personDTO, invalidFieldsDTO);

        // First insert person
        Person person = toPersonGRPC(personValidatedDTO);
        Person personValidated = dataServiceStub.validateSavePerson(person);
        Person personPersisted = dataServiceStub.savePerson(personValidated);

        // Last insert validated fields
        ValidationFields verifiedFieldsPersisted = validationFieldsServiceStub.saveVerifiedFields(ValidationFields.newBuilder().addAllVerifiedFields(valids).build());
        return DataDTO.builder().person(toPersonDTO(personPersisted)).validationFields(toValidationFieldsDTO(verifiedFieldsPersisted)).build();
    }
}
