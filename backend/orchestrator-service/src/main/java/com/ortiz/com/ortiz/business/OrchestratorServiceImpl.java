package com.ortiz.com.ortiz.business;

import com.ortiz.dto.DataDTO;
import com.ortiz.dto.PersonDTO;
import com.ortiz.dto.PhoneDTO;
import com.ortiz.dto.VerifiedFieldDTO;
import com.ortiz.grpc.services.DataServiceGrpc;
import com.ortiz.grpc.services.Person;
import com.ortiz.grpc.services.Phone;
import com.ortiz.grpc.services.vfs.ValidationFieldsServiceGrpc;
import com.ortiz.grpc.services.vfs.VerifiedField;
import com.ortiz.grpc.services.vfs.VerifiedFields;
import com.ortiz.poc.commons.FieldUtils;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.ortiz.poc.commons.FieldUtils.*;

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
        List<VerifiedFieldDTO> verifiedFields = dataDTO.getVerifiedFields();
        List<VerifiedField> verifiedFieldList = verifiedFields.stream().map(verifiedFieldDTO -> {
            return toVerifyFieldGrpc(verifiedFieldDTO);
        }).collect(Collectors.toList());
        VerifiedFields verifiedFieldsRequest = VerifiedFields.newBuilder().addAllVerifiedFields(verifiedFieldList).build();
        VerifiedFields verifiedFieldsValidated = validationFieldsServiceStub.validateFields(verifiedFieldsRequest);
        List<VerifiedField> valids = verifiedFieldsValidated.getVerifiedFieldsList().stream().filter(verifiedField -> verifiedField.getServerValidated().getValue()).collect(Collectors.toList());
        List<VerifiedField> invalids = verifiedFieldsValidated.getVerifiedFieldsList().stream().filter(verifiedField -> !verifiedField.getServerValidated().getValue()).collect(Collectors.toList());
        List<VerifiedFieldDTO> invalidVerifyDto = invalids.stream().map(verifiedField -> toVerifyFieldDto(verifiedField)).collect(Collectors.toList());
        PersonDTO personValidatedDTO = dataFilteringService.filterData(personDTO, invalidVerifyDto);
        Person person = toPerson(personValidatedDTO);
        Person personValidated = dataServiceStub.validateSavePerson(person);
        Person personPersisted = dataServiceStub.savePerson(personValidated);
        VerifiedFields verifiedFieldsPersisted = validationFieldsServiceStub.saveVerifiedFields(VerifiedFields.newBuilder().addAllVerifiedFields(valids).build());
        return DataDTO.builder().person(toPersonDTO(personPersisted)).verifiedFields(toVerifyFieldsDto(verifiedFieldsPersisted)).build();
    }


    public VerifiedFieldDTO toVerifyFieldDto(VerifiedField verifiedField) {
        return VerifiedFieldDTO.builder()
                .id(verifiedField.getId().getValue())
                .tenantId(verifiedField.getTenantId().getValue())
                .personId(verifiedField.getPersonId().getValue())
                .fieldName(verifiedField.getFieldName().getValue())
                .value(verifiedField.getFieldValue().getValue())
                .level(verifiedField.getLevel().getValue())
                .validated(verifiedField.getValidated().getValue())
                .build();
    }

    public List<VerifiedFieldDTO> toVerifyFieldsDto(VerifiedFields verifyFields) {
        return verifyFields.getVerifiedFieldsList().stream().map(verifyField -> toVerifyFieldDto(verifyField)).collect(Collectors.toList());
    }

    public VerifiedField toVerifyFieldGrpc(VerifiedFieldDTO verifiedField) {
        return VerifiedField.newBuilder()
                .setId(getInteger64Value(verifiedField.getId()))
                .setTenantId(FieldUtils.getStringValue(verifiedField.getTenantId()))
                .setPersonId(getStringValue(verifiedField.getPersonId()))
                .setFieldName(getStringValue(verifiedField.getFieldName()))
                .setFieldValue(getStringValue(verifiedField.getValue()))
                .setLevel(getInteger32Value(verifiedField.getLevel()))
                .setValidated(getBooleanValue(verifiedField.getValidated()))
                .setServerValidated(getBooleanValue(verifiedField.getServerValidated()))
                .setCause(getStringValue(verifiedField.getCause()))
                .build();
    }

    public PersonDTO toPersonDTO(Person person) {
        List<PhoneDTO> phoneDTOS = person.getPhonesList().stream().map(phone -> PhoneDTO.builder().ddi(phone.getDdi().getValue()).ddd(phone.getDdd().getValue()).number(phone.getNumber().getValue()).extensionLine(phone.getExtensionLine().getValue()).build()).collect(Collectors.toList());
        PersonDTO personDTO = PersonDTO.builder().tenantId(person.getTenantId().getValue()).id(person.getPersonId().getValue()).cpfCnpj(person.getCpfCnpj().getValue())
                .name(person.getName().getValue()).type(person.getType().getValue()).cpfCnpj(person.getCpfCnpj().getValue()).phones(phoneDTOS).build();
        return personDTO;
    }

    public Person toPerson(PersonDTO personDTO) {
        List<Phone> phones = personDTO.getPhones().stream().map(phoneDTO -> Phone.newBuilder().setId(getStringValue(phoneDTO.getId())).setDdi(getInteger32Value(phoneDTO.getDdi())).setDdd(getInteger32Value(phoneDTO.getDdd())).setNumber(getInteger32Value(phoneDTO.getNumber())).setExtensionLine(getInteger32Value(phoneDTO.getExtensionLine())).build()).collect(Collectors.toList());
        Person person = Person.newBuilder().setTenantId(getStringValue(personDTO.getTenantId())).setPersonId(getStringValue(personDTO.getId())).setCpfCnpj(getStringValue(personDTO.getCpfCnpj())).setName(getStringValue(personDTO.getName())).setType(getStringValue(personDTO.getType())).addAllPhones(phones).build();
        return person;
    }
}
