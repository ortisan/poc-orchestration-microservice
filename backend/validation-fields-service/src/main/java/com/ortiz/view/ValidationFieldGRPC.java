package com.ortiz.view;

import com.google.rpc.Code;
import com.ortiz.business.IValidationFieldsService;

import com.ortiz.grpc.services.vfs.ValidationField;
import com.ortiz.grpc.services.vfs.ValidationFields;
import com.ortiz.grpc.services.vfs.ValidationFieldsServiceGrpc;
import com.ortiz.poc.dto.ValidationFieldDTO;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.ortiz.poc.commons.ErrorUtils.handleError;
import static com.ortiz.poc.commons.FieldUtils.*;
import static com.ortiz.poc.commons.GRPCMapper.*;

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
}

