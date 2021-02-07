package com.ortiz.business.impl;


import com.ortiz.business.IPersonService;
import com.ortiz.business.rules.IPersonRule;
import com.ortiz.domain.Person;
import com.ortiz.domain.mapper.IPersonBusinessMapper;
import com.ortiz.persistence.repositories.service.IPersonRepository;
import com.ortiz.poc.dto.PersonDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements IPersonService {

    private static final Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);

    @Autowired
    private IPersonRepository personRepository;

    @Autowired
    private IPersonBusinessMapper personBusinessMapper;

    @Autowired
    private IPersonRule personRule;


    @Override
    public PersonDTO getPerson(String tenantId, String personId) {
        final Person person = personRepository.getPerson(tenantId, personId);
        return personBusinessMapper.mapToDto(person);
    }

    @Override
    public PersonDTO validatePerson(PersonDTO personDTO, boolean isInsert) {
        final Person person = personBusinessMapper.mapToDomain(personDTO);
        personRule.validate(person, isInsert);
        return personDTO;
    }

    @Override
    public PersonDTO savePerson(PersonDTO personDTO) {
        validatePerson(personDTO, true);
        final Person person = personBusinessMapper.mapToDomain(personDTO);
        final Person personSaved = personRepository.savePerson(person);
        return personBusinessMapper.mapToDto(personSaved);
    }

    @Override
    public PersonDTO updatePerson(PersonDTO personDTO) {
        validatePerson(personDTO, false);
        final Person person = personBusinessMapper.mapToDomain(personDTO);
        final Person personSaved = personRepository.updatePerson(person);
        return personBusinessMapper.mapToDto(personSaved);
    }
}
