package com.ortiz.view;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ortiz.business.IValidationFieldsService;
import com.ortiz.dto.VerifiedFieldDTO;
import com.ortiz.grpc.services.DataServiceGrpc;
import com.ortiz.grpc.services.vfs.ValidationFieldsServiceGrpc;
import com.ortiz.grpc.services.vfs.VerifiedField;
import com.ortiz.grpc.services.vfs.VerifiedFields;
import io.grpc.stub.ServerCalls;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@GrpcService
public class ValidationFieldGRPC extends ValidationFieldsServiceGrpc.ValidationFieldsServiceImplBase {

    @Autowired
    private IValidationFieldsService validationFieldsService;

    public void validateFields(VerifiedFields request, StreamObserver<VerifiedFields> responseObserver) {

//
//        private Long id;
//        @JsonIgnore
//        private String tenantId;
//        @JsonIgnore
//        private String personId;
//        @JsonProperty("field_name")
//        private String fieldName;
//        private String value;
//        private Integer level;
//        private Boolean validated;
//        @JsonProperty("created_date")
//        private LocalDateTime createdDate;
//        private String cause;
//        @JsonProperty("server_validated")
//        private boolean serverValidated;

        List<VerifiedField> verifiedFields = request.getVerifiedFieldsList().stream().map(verifiedField -> {
            VerifiedFieldDTO verifiedFieldDTO = VerifiedFieldDTO.builder()
                    .id(verifiedField.getId().getValue())
                    .tenantId(verifiedField.getTenantId().getValue())
                    .personId(verifiedField.getPersonId().getValue())
                    .fieldName(verifiedField.getFieldName().getValue())
                    .value(verifiedField.getFieldValue().getValue())
                    .level(verifiedField.getLevel().getValue())
                    .validated(verifiedField.getValidated().getValue())
//                    .createdDate(verifiedField.getCreatedDate())
                    .build();
            return verifiedField;
        }).collect(Collectors.toList());

        validationFieldsService.validateFields(verifiedFields);

    }

    public void saveVerifiedFields(VerifiedFields request, StreamObserver<VerifiedFields> responseObserver) {
    }


}
