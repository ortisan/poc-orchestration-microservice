package com.ortiz.poc.commons;

import com.ortiz.grpc.services.Person;
import com.ortiz.grpc.services.Phone;
import com.ortiz.grpc.services.vfs.ValidationField;
import com.ortiz.grpc.services.vfs.ValidationFields;
import com.ortiz.poc.dto.PersonDTO;
import com.ortiz.poc.dto.PhoneDTO;
import com.ortiz.poc.dto.ValidationFieldDTO;

import java.util.List;
import java.util.stream.Collectors;

import static com.ortiz.poc.commons.FieldUtils.*;
import static com.ortiz.poc.commons.PerserUtil.toLocalDateTime;
import static com.ortiz.poc.commons.PerserUtil.toTimestamp;

public class GRPCMapper {

    public static PersonDTO toPersonDTO(Person person) {
        List<PhoneDTO> phoneDTOS = toPhonesDTO(person.getPhonesList());
        PersonDTO personDTO = PersonDTO.builder().tenantId(person.getTenantId().getValue()).id(person.getPersonId().getValue()).cpfCnpj(person.getCpfCnpj().getValue())
                .name(person.getName().getValue()).type(person.getType().getValue()).cpfCnpj(person.getCpfCnpj().getValue()).phones(phoneDTOS).build();
        return personDTO;
    }

    public static Person toPersonGRPC(PersonDTO personDTO) {
        List<Phone> phones = toPhonesGRPC(personDTO.getPhones());
        Person person = Person.newBuilder().setTenantId(getStringValue(personDTO.getTenantId())).setPersonId(getStringValue(personDTO.getId())).setCpfCnpj(getStringValue(personDTO.getCpfCnpj())).setName(getStringValue(personDTO.getName())).setType(getStringValue(personDTO.getType())).addAllPhones(phones).build();
        return person;
    }

    public static List<PhoneDTO> toPhonesDTO(List<Phone> phones) {
        return phones.stream().map(phone -> toPhoneDTO(phone)).collect(Collectors.toList());
    }

    public static PhoneDTO toPhoneDTO(Phone phoneDTO) {
        return PhoneDTO.builder().ddi(phoneDTO.getDdi().getValue()).ddd(phoneDTO.getDdd().getValue()).number(phoneDTO.getNumber().getValue()).extensionLine(phoneDTO.getExtensionLine().getValue()).build();
    }

    public static List<Phone> toPhonesGRPC(List<PhoneDTO> phonesDTO) {
        return phonesDTO.stream().map(phoneDTO -> toPhoneGRPC(phoneDTO)).collect(Collectors.toList());
    }

    public static Phone toPhoneGRPC(PhoneDTO phoneDTO) {
        return Phone.newBuilder().setId(getStringValue(phoneDTO.getId())).setDdi(getInteger32Value(phoneDTO.getDdi())).setDdd(getInteger32Value(phoneDTO.getDdd())).setNumber(getInteger32Value(phoneDTO.getNumber())).setExtensionLine(getInteger32Value(phoneDTO.getExtensionLine())).build();
    }


    public static List<ValidationFieldDTO> toValidationFieldsDTO(ValidationFields validationFields) {
        return validationFields.getVerifiedFieldsList().stream().map(validationField -> toValidationFieldDTO(validationField)).collect(Collectors.toList());
    }

    public static ValidationFieldDTO toValidationFieldDTO(ValidationField validationField) {
        return ValidationFieldDTO.builder()
                .id(validationField.getId().getValue())
                .tenantId(validationField.getTenantId().getValue())
                .personId(validationField.getPersonId().getValue())
                .fieldName(validationField.getFieldName().getValue())
                .value(validationField.getFieldValue().getValue())
                .level(validationField.getLevel().getValue())
                .validated(validationField.getValidated().getValue())
                .createdDate(toLocalDateTime(validationField.getCreatedDate()))
                .build();
    }

    public static ValidationFields toValidationFieldsGRPC(List<ValidationFieldDTO> validationFieldsDTOS) {
        List<ValidationField> verifiedFieldList = validationFieldsDTOS.stream().map(validationFieldDTO -> {
            return toValidationFieldGRPC(validationFieldDTO);
        }).collect(Collectors.toList());
        return ValidationFields.newBuilder().addAllVerifiedFields(verifiedFieldList).build();
    }

    public static ValidationField toValidationFieldGRPC(ValidationFieldDTO validationFieldDTO) {
        return ValidationField.newBuilder()
                .setId(getInteger64Value(validationFieldDTO.getId()))
                .setTenantId(getStringValue(validationFieldDTO.getTenantId()))
                .setPersonId(getStringValue(validationFieldDTO.getPersonId()))
                .setFieldName(getStringValue(validationFieldDTO.getFieldName()))
                .setFieldValue(getStringValue(validationFieldDTO.getValue()))
                .setLevel(getInteger32Value(validationFieldDTO.getLevel()))
                .setValidated(getBooleanValue(validationFieldDTO.getValidated()))
                .setServerValidated(getBooleanValue(validationFieldDTO.getServerValidated()))
                .setCause(getStringValue(validationFieldDTO.getCause()))
                .setCreatedDate(toTimestamp(validationFieldDTO.getCreatedDate()))
                .build();
    }
}
