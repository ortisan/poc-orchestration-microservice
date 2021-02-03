package com.ortiz.business.impl;


import com.ortiz.business.IValidationFieldsService;
import com.ortiz.domain.VerifiedFieldDomain;
import com.ortiz.domain.mapper.IVerifiedFieldBusinessMapper;
import com.ortiz.dto.VerifiedFieldDTO;
import com.ortiz.grpc.services.DataServiceGrpc;
import com.ortiz.grpc.services.GetPersonRequest;
import com.ortiz.grpc.services.Person;
import com.ortiz.persistence.repositories.jpa.IFieldJpaRepository;
import com.ortiz.persistence.repositories.service.IVerifyFieldRepository;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ValidationFieldsServiceImpl implements IValidationFieldsService {

    @Autowired
    private IVerifyFieldRepository verifyFieldRepository;

    @Autowired
    private IFieldJpaRepository fieldJpaRepository;

    @Autowired
    private IVerifiedFieldBusinessMapper fieldsBusinessMapper;

    @GrpcClient("data-service")
    private DataServiceGrpc.DataServiceBlockingStub dataServiceStub;


    @Override
    public List<VerifiedFieldDTO> getVerifiedFields(String tenantId, String personId) {
        validatePerson(tenantId, personId);
        List<VerifiedFieldDomain> fieldsByPerson = verifyFieldRepository.getVerifiedFieldsByPerson(tenantId, personId);
        return fieldsBusinessMapper.toDtoList(fieldsByPerson);
    }

    @Override
    public List<VerifiedFieldDTO> saveVerifiedFields(List<VerifiedFieldDTO> verifiedFieldDTOS) {
        validateFields(verifiedFieldDTOS);
        List<VerifiedFieldDomain> verifiedFieldDomains = fieldsBusinessMapper.toDomainList(verifiedFieldDTOS);
        VerifiedFieldDTO verifiedFieldDTO = verifiedFieldDTOS.stream().findFirst().get();
        validatePerson(verifiedFieldDTO.getTenantId(), verifiedFieldDTO.getPersonId());

        final List<VerifiedFieldDomain> savedVerifiedFieldDomains = verifyFieldRepository.saveVerifiedFields(verifiedFieldDomains);
        return fieldsBusinessMapper.toDtoList(savedVerifiedFieldDomains);
    }

    @Override
    public List<VerifiedFieldDTO> updateVerifiedFields(List<VerifiedFieldDTO> verifiedFieldDTOS) {
        validateFields(verifiedFieldDTOS);
        VerifiedFieldDTO verifiedFieldDTO = verifiedFieldDTOS.stream().findFirst().get();
        validatePerson(verifiedFieldDTO.getTenantId(), verifiedFieldDTO.getPersonId());

        List<VerifiedFieldDomain> verifiedFieldDomains = fieldsBusinessMapper.toDomainList(verifiedFieldDTOS);
        List<VerifiedFieldDomain> savedVerifiedFieldDomains = verifyFieldRepository.updateVerifiedFields(verifiedFieldDomains);
        return fieldsBusinessMapper.toDtoList(savedVerifiedFieldDomains);
    }

    private void validatePerson(String tenantId, String personId) {
        GetPersonRequest personRequest = GetPersonRequest.newBuilder().setTenantId(tenantId).setPersonId(personId).build();
        try {
            Person personResponse = dataServiceStub.getPerson(personRequest);
        } catch (StatusRuntimeException exc) {
            if (exc.getStatus().getCode() == Status.Code.NOT_FOUND) {
                throw new EntityNotFoundException("Person not found.");
            }
            throw exc;
        }

    }

    private void validateFields(List<VerifiedFieldDTO> verifiedFieldDTOS) {
        List<String> fieldNames = verifiedFieldDTOS.stream().map(verifiedFieldDTO -> verifiedFieldDTO.getFieldName()).collect(Collectors.toList());
        List<String> fieldsNamesPersisted = fieldJpaRepository.findAll().stream().map(field -> field.getName()).collect(Collectors.toList());
        fieldNames.removeAll(fieldsNamesPersisted);
        if (!fieldNames.isEmpty()) {
            throw new IllegalArgumentException(String.format("Invalid fields: %s.", fieldNames.stream().collect(Collectors.joining(","))));
        }

    }
}
