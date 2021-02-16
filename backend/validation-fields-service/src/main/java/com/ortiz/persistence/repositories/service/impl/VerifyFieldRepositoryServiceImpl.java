package com.ortiz.persistence.repositories.service.impl;

import com.ortiz.domain.VerifiedFieldDomain;
import com.ortiz.persistence.entities.VerifiedFieldEntity;
import com.ortiz.persistence.mapper.IVerifiedFieldsRepositoryMapper;
import com.ortiz.persistence.repositories.jpa.IVerifiedFieldRepositoryJpa;
import com.ortiz.persistence.repositories.service.IVerifyFieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class VerifyFieldRepositoryServiceImpl implements IVerifyFieldRepository {

    @Autowired
    private IVerifiedFieldRepositoryJpa verifiedFieldRepositoryJpa;

    @Autowired
    private IVerifiedFieldsRepositoryMapper verifiedFieldsRepositoryMapper;

    @Override
    public List<VerifiedFieldDomain> getVerifiedFieldsByPerson(String tenantId, String personId) {
        List<VerifiedFieldEntity> entities = verifiedFieldRepositoryJpa.findByTenantAndPersonId(tenantId, personId).stream().collect(Collectors.toList());
        return verifiedFieldsRepositoryMapper.collectionEntityToDomain(entities);
    }

    @Override
    public List<VerifiedFieldDomain> saveVerifiedFields(List<VerifiedFieldDomain> fields) {
        List<VerifiedFieldEntity> entities = verifiedFieldsRepositoryMapper.collectionDomainToEntity(fields);
        Iterator<VerifiedFieldEntity> entititesSaved = verifiedFieldRepositoryJpa.saveAll(entities).iterator();
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(entititesSaved, Spliterator.ORDERED), false).map(verifiedFieldEntity -> verifiedFieldsRepositoryMapper.entityToDomain(verifiedFieldEntity)).collect(Collectors.toList());
    }

    @Override
    public List<VerifiedFieldDomain> deleteSavedVerifiedFields(List<VerifiedFieldDomain> fields) {
        List<VerifiedFieldEntity> entities = verifiedFieldsRepositoryMapper.collectionDomainToEntity(fields);
        verifiedFieldRepositoryJpa.deleteAll(entities);
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(entities.iterator(), Spliterator.ORDERED), false).map(verifiedFieldEntity -> verifiedFieldsRepositoryMapper.entityToDomain(verifiedFieldEntity)).collect(Collectors.toList());
    }

    @Override
    public List<VerifiedFieldDomain> updateVerifiedFields(List<VerifiedFieldDomain> fields) {
        List<VerifiedFieldEntity> entities = verifiedFieldsRepositoryMapper.collectionDomainToEntity(fields);
        Iterator<VerifiedFieldEntity> entititesSaved = verifiedFieldRepositoryJpa.saveAll(entities).iterator();
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(entititesSaved, Spliterator.ORDERED), false).map(verifiedFieldEntity -> verifiedFieldsRepositoryMapper.entityToDomain(verifiedFieldEntity)).collect(Collectors.toList());
    }
}
