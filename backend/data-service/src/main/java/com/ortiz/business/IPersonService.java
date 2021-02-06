package com.ortiz.business;

import com.ortiz.poc.dto.PersonDTO;

public interface IPersonService {
    PersonDTO getPerson(String tenantId, String personId);

    PersonDTO savePerson(PersonDTO personDTO);

    PersonDTO updatePerson(PersonDTO personDTO);
}
