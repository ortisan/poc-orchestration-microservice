package com.ortiz.persistence.repositories.service;

import com.ortiz.domain.Person;

public interface IPersonRepository {
    Person getPerson(String tenantId, String personId);
    Person savePerson(Person person);
    Person updatePerson(Person person);
}
