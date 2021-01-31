package com.ortiz.business.impl;


import com.ortiz.business.IVerifiedFieldsService;
import com.ortiz.domain.VerifiedFieldDomain;
import com.ortiz.domain.mapper.IVerifiedFieldBusinessMapper;
import com.ortiz.dto.VerifiedFieldDTO;
import com.ortiz.persistence.entities.Field;
import com.ortiz.persistence.repositories.jpa.IFieldJpaRepository;
import com.ortiz.persistence.repositories.service.IVerifyFieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VerifyFieldsServiceImpl implements IVerifiedFieldsService {

    @Autowired
    private IVerifyFieldRepository verifyFieldRepository;

    @Autowired
    private IFieldJpaRepository fieldJpaRepository;

    @Autowired
    private IVerifiedFieldBusinessMapper fieldsBusinessMapper;

    @Override
    public List<VerifiedFieldDTO> getVerifiedFields(String tenantId, String personId) {
        List<VerifiedFieldDomain> fieldsByPerson = verifyFieldRepository.getVerifiedFieldsByPerson(tenantId, personId);
        return fieldsBusinessMapper.toDtoList(fieldsByPerson);
    }

    @Override
    public List<VerifiedFieldDTO> saveVerifiedFields(List<VerifiedFieldDTO> verifiedFieldDTOS) {
        validateFields(verifiedFieldDTOS);
        List<VerifiedFieldDomain> verifiedFieldDomains = fieldsBusinessMapper.toDomainList(verifiedFieldDTOS);
        final List<VerifiedFieldDomain> savedVerifiedFieldDomains = verifyFieldRepository.saveVerifiedFields(verifiedFieldDomains);
        return fieldsBusinessMapper.toDtoList(savedVerifiedFieldDomains);
    }

    @Override
    public List<VerifiedFieldDTO> updateVerifiedFields(List<VerifiedFieldDTO> verifiedFieldDTOS) {
        validateFields(verifiedFieldDTOS);
        List<VerifiedFieldDomain> verifiedFieldDomains = fieldsBusinessMapper.toDomainList(verifiedFieldDTOS);
        List<VerifiedFieldDomain> savedVerifiedFieldDomains = verifyFieldRepository.updateVerifiedFields(verifiedFieldDomains);
        return fieldsBusinessMapper.toDtoList(savedVerifiedFieldDomains);
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
