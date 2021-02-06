package com.ortiz.view;

import com.google.rpc.Code;
import com.ortiz.business.IValidationFieldsService;
import com.ortiz.dto.ValidationFieldDTO;
import com.ortiz.grpc.services.vfs.ValidationField;
import com.ortiz.grpc.services.vfs.ValidationFields;
import com.ortiz.grpc.services.vfs.ValidationFieldsServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.ortiz.poc.commons.ErrorUtils.handleError;
import static com.ortiz.poc.commons.FieldUtils.*;

@GrpcService
public class ValidationFieldGRPC extends ValidationFieldsServiceGrpc.ValidationFieldsServiceImplBase {

    @Autowired
    private IValidationFieldsService validationFieldsService;

    public void validateFields(ValidationFields request, StreamObserver<ValidationFields> responseObserver) {
        try {
            List<ValidationFieldDTO> verifiedFields = toValidationFieldsDTO(request);

            List<ValidationFieldDTO> validatedFields = validationFieldsService.validateFields(verifiedFields);

            ValidationFields verifiedFieldsResponse = toValidationFieldsGRPC(validatedFields);
            responseObserver.onNext(verifiedFieldsResponse);
            responseObserver.onCompleted();
        } catch (EntityNotFoundException exc) {
            responseObserver.onError(handleError(exc, Code.NOT_FOUND, request));
        } catch (Exception exc) {
            responseObserver.onError(handleError(exc, Code.ABORTED, request));
        }
    }

    public void saveVerifiedFields(ValidationFields request, StreamObserver<ValidationFields> responseObserver) {
        try {
            List<ValidationFieldDTO> validationFieldDTOS = toValidationFieldsDTO(request);

            List<ValidationFieldDTO> validated = validationFieldsService.validateFields(validationFieldDTOS);

            List<ValidationFieldDTO> fieldsValidated = validated.stream().filter(verifiedFieldDTO -> verifiedFieldDTO.getServerValidated()).collect(Collectors.toList());
            List<ValidationFieldDTO> fieldsNotValid = validated.stream().filter(verifiedFieldDTO -> !verifiedFieldDTO.getServerValidated()).collect(Collectors.toList());

            // save only valids
            List<ValidationFieldDTO> fieldsPersisted = validationFieldsService.saveVerifiedFields(fieldsValidated);

            List<ValidationFieldDTO> fieldsToReturn = new ArrayList<>(fieldsNotValid);
            fieldsToReturn.addAll(fieldsPersisted);

            ValidationFields validationFieldsResponse = toValidationFieldsGRPC(fieldsToReturn);
            responseObserver.onNext(validationFieldsResponse);
            responseObserver.onCompleted();
        } catch (EntityNotFoundException exc) {
            responseObserver.onError(handleError(exc, Code.NOT_FOUND, request));
        } catch (Exception exc) {
            responseObserver.onError(handleError(exc, Code.ABORTED, request));
        }
    }

    public List<ValidationFieldDTO> toValidationFieldsDTO(ValidationFields validationFields) {
        return validationFields.getVerifiedFieldsList().stream().map(validationField -> toValidationFieldDTO(validationField)).collect(Collectors.toList());
    }

    public ValidationFieldDTO toValidationFieldDTO(ValidationField validationField) {
        return ValidationFieldDTO.builder()
                .id(validationField.getId().getValue())
                .tenantId(validationField.getTenantId().getValue())
                .personId(validationField.getPersonId().getValue())
                .fieldName(validationField.getFieldName().getValue())
                .value(validationField.getFieldValue().getValue())
                .level(validationField.getLevel().getValue())
                .validated(validationField.getValidated().getValue())
                .build();
    }

    public ValidationFields toValidationFieldsGRPC(List<ValidationFieldDTO> validationFieldsDTOS) {
        List<ValidationField> verifiedFieldList = validationFieldsDTOS.stream().map(validationFieldDTO -> {
            return toValidationFieldGRPC(validationFieldDTO);
        }).collect(Collectors.toList());
        return ValidationFields.newBuilder().addAllVerifiedFields(verifiedFieldList).build();
    }

    public ValidationField toValidationFieldGRPC(ValidationFieldDTO validationFieldDTO) {
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
                .build();

    }
}
