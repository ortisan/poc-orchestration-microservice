package com.ortiz.persistence.repositories.service.impl;

import com.ortiz.domain.CorporatePerson;
import com.ortiz.domain.DocumentTypeEnum;
import com.ortiz.domain.Person;
import com.ortiz.domain.PhysicalPerson;
import com.ortiz.domain.enums.PersonTypeEnum;
import com.ortiz.persistence.entities.PersonId;
import com.ortiz.persistence.entities.PersonIdentity;
import com.ortiz.persistence.mapper.IPersonRepositoryMapper;
import com.ortiz.persistence.repositories.jpa.IPersonIdentityRepositoryJpa;
import com.ortiz.persistence.repositories.jpa.IPersonRepositoryJpa;
import com.ortiz.persistence.repositories.service.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonRepositoryServiceImpl implements IPersonRepository {

    @Autowired
    private IPersonRepositoryJpa personRepositoryJpa;

    @Autowired
    private IPersonIdentityRepositoryJpa personIdentityRepositoryJpa;

    @Autowired
    private IPersonRepositoryMapper personRepositoryMapper;


    @Override
    public Person getPerson(String tenantId, String personId) {
        final PersonId personIdentifier = new PersonId(tenantId, personId);
        final Optional<com.ortiz.persistence.entities.Person> optionalPerson = personRepositoryJpa.findById(personIdentifier);
        return optionalPerson.map(p -> personRepositoryMapper.mapToDomain(p)).orElseThrow(() -> new EntityNotFoundException("Person not found"));
    }

    @Override
    public Person savePerson(Person person) {
        final PersonIdentity personIdentity = getOrCreatePersonIdentity(person);
        final com.ortiz.persistence.entities.Person personEntity = personRepositoryMapper.mapToEntity(person);
        personEntity.getPersonId().setPersonId(personIdentity.getId());
        personEntity.getPhones().forEach(phone -> phone.setId(UUID.randomUUID().toString()));
        final com.ortiz.persistence.entities.Person personEntitySaved = personRepositoryJpa.save(personEntity);
        return personRepositoryMapper.mapToDomain(personEntitySaved);
    }

    @Override
    public Person updatePerson(Person person) {
        final com.ortiz.persistence.entities.Person personEntity = personRepositoryMapper.mapToEntity(person);
        final com.ortiz.persistence.entities.Person personEntitySaved = personRepositoryJpa.save(personEntity);
        return personRepositoryMapper.mapToDomain(personEntitySaved);
    }

    private PersonIdentity getOrCreatePersonIdentity(Person person) {
        final DocumentTypeEnum documentTypeEnum;
        if (person.getPersonType() == PersonTypeEnum.PHISICAL) {
            documentTypeEnum = DocumentTypeEnum.CPF;
        } else {
            documentTypeEnum = DocumentTypeEnum.CNPJ;
        }
        final String documentNumber;
        if (person instanceof PhysicalPerson) {
            documentNumber = ((PhysicalPerson) person).getCpf();
        } else {
            documentNumber = ((CorporatePerson) person).getCnpj();
        }
        final Collection<PersonIdentity> identities = personIdentityRepositoryJpa.findByDocumentTypeAndNumber(documentTypeEnum, documentNumber);
        final PersonIdentity personIdentity = identities.stream().findFirst().orElseGet(() -> personIdentityRepositoryJpa.save(new PersonIdentity(UUID.randomUUID().toString(), documentTypeEnum, documentNumber, "BR")));
        return personIdentity;
    }
}
