package com.ortiz.business.impl;

import com.ortiz.business.IPhoneService;
import com.ortiz.business.rules.IPhoneRule;
import com.ortiz.domain.Phone;
import com.ortiz.domain.mapper.IPhoneBusinessMapper;
import com.ortiz.dto.PhoneDTO;
import com.ortiz.persistence.repositories.service.IPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneServiceImpl implements IPhoneService {

    @Autowired
    private IPhoneBusinessMapper phoneBusinessMapper;

    @Autowired
    private IPhoneRule phoneRule;

    @Autowired
    private IPhoneRepository phoneRepository;

    @Override
    public PhoneDTO getPhone(String phoneId) {
        return phoneBusinessMapper.domainToDto(phoneRepository.getPhone(phoneId));
    }

    @Override
    public PhoneDTO savePhone(PhoneDTO phoneDTO) {
        Phone phone = phoneBusinessMapper.dtoToDomain(phoneDTO);
        phone.setInsert(true);
        phoneRule.validate(phone);
        Phone phonePersisted = phoneRepository.savePhone(phone);
        return phoneBusinessMapper.domainToDto(phonePersisted);
    }

    @Override
    public PhoneDTO updatePhone(PhoneDTO phoneDTO) {
        Phone phone = phoneBusinessMapper.dtoToDomain(phoneDTO);
        phone.setInsert(false);
        phoneRule.validate(phone);
        Phone phonePersisted = phoneRepository.updatePhone(phone);
        return phoneBusinessMapper.domainToDto(phonePersisted);
    }
}
