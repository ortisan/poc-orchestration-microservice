package com.ortiz.view;

import com.google.rpc.Code;
import com.ortiz.business.IValidationFieldsService;
import com.ortiz.dto.VerifiedFieldDTO;
import com.ortiz.grpc.services.vfs.ValidationFieldsServiceGrpc;
import com.ortiz.grpc.services.vfs.VerifiedField;
import com.ortiz.grpc.services.vfs.VerifiedFields;
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

    public void validateFields(VerifiedFields request, StreamObserver<VerifiedFields> responseObserver) {
        try {
            List<VerifiedFieldDTO> verifiedFields = request.getVerifiedFieldsList().stream().map(verifiedField -> {
                return VerifiedFieldDTO.builder()
                        .id(verifiedField.getId().getValue())
                        .tenantId(verifiedField.getTenantId().getValue())
                        .personId(verifiedField.getPersonId().getValue())
                        .fieldName(verifiedField.getFieldName().getValue())
                        .value(verifiedField.getFieldValue().getValue())
                        .level(verifiedField.getLevel().getValue())
                        .validated(verifiedField.getValidated().getValue())
                        .build();
            }).collect(Collectors.toList());

            List<VerifiedFieldDTO> validated = validationFieldsService.validateFields(verifiedFields);
            List<VerifiedField> verifiedFieldList = validated.stream().map(verifiedFieldDTO -> {
                return VerifiedField.newBuilder()
                        .setId(getInteger64Value(verifiedFieldDTO.getId()))
                        .setTenantId(getStringValue(verifiedFieldDTO.getTenantId()))
                        .setPersonId(getStringValue(verifiedFieldDTO.getPersonId()))
                        .setFieldName(getStringValue(verifiedFieldDTO.getFieldName()))
                        .setFieldValue(getStringValue(verifiedFieldDTO.getValue()))
                        .setLevel(getInteger32Value(verifiedFieldDTO.getLevel()))
                        .setValidated(getBooleanValue(verifiedFieldDTO.getValidated()))
                        .setServerValidated(getBooleanValue(verifiedFieldDTO.getServerValidated()))
                        .setCause(getStringValue(verifiedFieldDTO.getCause()))
                        .build();
            }).collect(Collectors.toList());
            VerifiedFields verifiedFieldsResponse = VerifiedFields.newBuilder().addAllVerifiedFields(verifiedFieldList).build();
            responseObserver.onNext(verifiedFieldsResponse);
            responseObserver.onCompleted();
        } catch (EntityNotFoundException exc) {
            responseObserver.onError(handleError(exc, Code.NOT_FOUND, request));
        } catch (Exception exc) {
            responseObserver.onError(handleError(exc, Code.ABORTED, request));
        }
    }

    public void saveVerifiedFields(VerifiedFields request, StreamObserver<VerifiedFields> responseObserver) {
        try {
            List<VerifiedFieldDTO> verifiedFields = request.getVerifiedFieldsList().stream().map(verifiedField -> {
                return VerifiedFieldDTO.builder()
                        .id(verifiedField.getId().getValue())
                        .tenantId(verifiedField.getTenantId().getValue())
                        .personId(verifiedField.getPersonId().getValue())
                        .fieldName(verifiedField.getFieldName().getValue())
                        .value(verifiedField.getFieldValue().getValue())
                        .level(verifiedField.getLevel().getValue())
                        .validated(verifiedField.getValidated().getValue())
                        .build();
            }).collect(Collectors.toList());

            List<VerifiedFieldDTO> validated = validationFieldsService.validateFields(verifiedFields);

            List<VerifiedFieldDTO> fieldsValidated = validated.stream().filter(verifiedFieldDTO -> verifiedFieldDTO.getServerValidated()).collect(Collectors.toList());
            List<VerifiedFieldDTO> fieldsNotValid = validated.stream().filter(verifiedFieldDTO -> !verifiedFieldDTO.getServerValidated()).collect(Collectors.toList());


            List<VerifiedFieldDTO> fieldsPersisted = validationFieldsService.saveVerifiedFields(fieldsValidated);

            List<VerifiedFieldDTO> fieldsToReturn = new ArrayList<>(fieldsNotValid);
            fieldsToReturn.addAll(fieldsPersisted);

            List<VerifiedField> verifiedFieldList = fieldsToReturn.stream().map(verifiedFieldDTO -> {
                return VerifiedField.newBuilder()
                        .setId(getInteger64Value(verifiedFieldDTO.getId()))
                        .setTenantId(getStringValue(verifiedFieldDTO.getTenantId()))
                        .setPersonId(getStringValue(verifiedFieldDTO.getPersonId()))
                        .setFieldName(getStringValue(verifiedFieldDTO.getFieldName()))
                        .setFieldValue(getStringValue(verifiedFieldDTO.getValue()))
                        .setLevel(getInteger32Value(verifiedFieldDTO.getLevel()))
                        .setValidated(getBooleanValue(verifiedFieldDTO.getValidated()))
                        .setServerValidated(getBooleanValue(verifiedFieldDTO.getServerValidated()))
                        .setCause(getStringValue(verifiedFieldDTO.getCause()))
                        .build();
            }).collect(Collectors.toList());
            VerifiedFields verifiedFieldsResponse = VerifiedFields.newBuilder().addAllVerifiedFields(verifiedFieldList).build();
            responseObserver.onNext(verifiedFieldsResponse);
            responseObserver.onCompleted();
        } catch (EntityNotFoundException exc) {
            responseObserver.onError(handleError(exc, Code.NOT_FOUND, request));
        } catch (Exception exc) {
            responseObserver.onError(handleError(exc, Code.ABORTED, request));
        }
    }
}
