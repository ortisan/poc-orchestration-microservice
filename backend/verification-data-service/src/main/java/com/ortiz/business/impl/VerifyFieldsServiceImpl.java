package com.ortiz.business.impl;


import com.ortiz.business.IVerifiedFieldsService;
import com.ortiz.domain.VerifiedFieldDomain;
import com.ortiz.domain.mapper.IVerifiedFieldBusinessMapper;
import com.ortiz.dto.VerifiedFieldDTO;
import com.ortiz.persistence.repositories.service.IVerifyFieldRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VerifyFieldsServiceImpl implements IVerifiedFieldsService {

    private static final Logger logger = LoggerFactory.getLogger(VerifyFieldsServiceImpl.class);

    @Autowired
    private IVerifyFieldRepository verifyFieldRepository;

    @Autowired
    private IVerifiedFieldBusinessMapper fieldsBusinessMapper;

    @Override
    public List<VerifiedFieldDTO> getFields(String tenantId, String personId) {
        List<VerifiedFieldDomain> fieldsByPerson = verifyFieldRepository.getVerifiedFieldsByPerson(tenantId, personId);
        return fieldsBusinessMapper.toDtoList(fieldsByPerson);
    }

    @Override
    public List<VerifiedFieldDTO> saveFields(List<VerifiedFieldDTO> verifiedFieldDTOS) {



        List<VerifiedFieldDomain> verifiedFieldDomains = fieldsBusinessMapper.toDomainList(verifiedFieldDTOS);
        final List<VerifiedFieldDomain> savedVerifiedFieldDomains = verifyFieldRepository.saveVerifiedFields(verifiedFieldDomains);
        return fieldsBusinessMapper.toDtoList(savedVerifiedFieldDomains);
    }

    @Override
    public List<VerifiedFieldDTO> updateFields(List<VerifiedFieldDTO> verifiedFieldDTOS) {
        List<VerifiedFieldDomain> verifiedFieldDomains = fieldsBusinessMapper.toDomainList(verifiedFieldDTOS);
        List<VerifiedFieldDomain> savedVerifiedFieldDomains = verifyFieldRepository.updateVerifiedFields(verifiedFieldDomains);
        return fieldsBusinessMapper.toDtoList(savedVerifiedFieldDomains);
    }
}
