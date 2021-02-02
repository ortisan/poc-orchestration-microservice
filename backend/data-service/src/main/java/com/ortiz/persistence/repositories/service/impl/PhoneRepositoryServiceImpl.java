package com.ortiz.persistence.repositories.service.impl;

import com.ortiz.domain.Phone;
import com.ortiz.persistence.mapper.IPhoneRepositoryMapper;
import com.ortiz.persistence.repositories.jpa.IPhoneRepositoryJpa;
import com.ortiz.persistence.repositories.service.IPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class PhoneRepositoryServiceImpl implements IPhoneRepository {

    @Autowired
    private IPhoneRepositoryJpa phoneRepositoryJpa;

    @Autowired
    private IPhoneRepositoryMapper phoneRepositoryMapper;

    @Override
    public Phone getPhone(String phoneId) {
        final Optional<com.ortiz.persistence.entities.Phone> optionalPhone = phoneRepositoryJpa.findById(phoneId);
        return optionalPhone.map(p -> phoneRepositoryMapper.entityToDomain(p)).orElseThrow(() -> new EntityNotFoundException("Phone not found"));
    }

    @Override
    public Phone savePhone(Phone phone) {
        if (phoneRepositoryJpa.existsById(phone.getId())) {
            throw new IllegalStateException("Phone already exists");
        }
        com.ortiz.persistence.entities.Phone phoneEntity = phoneRepositoryMapper.domainToEntity(phone);
        com.ortiz.persistence.entities.Phone phoneEntityPersisted = phoneRepositoryJpa.save(phoneEntity);
        return phoneRepositoryMapper.entityToDomain(phoneEntityPersisted);
    }

    @Override
    public Phone updatePhone(Phone phone) {
        if (!phoneRepositoryJpa.existsById(phone.getId())) {
            throw new IllegalStateException("Phone does not exists");
        }
        com.ortiz.persistence.entities.Phone phoneEntity = phoneRepositoryMapper.domainToEntity(phone);
        com.ortiz.persistence.entities.Phone phoneEntityPersisted = phoneRepositoryJpa.save(phoneEntity);
        return phoneRepositoryMapper.entityToDomain(phoneEntityPersisted);
    }
}
