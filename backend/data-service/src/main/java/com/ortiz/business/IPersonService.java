package com.ortiz.business;

import com.ortiz.poc.dto.PersonDTO;

public interface IPersonService {
    PersonDTO getPerson(String tenantId, String personId);

    PersonDTO validatePerson(PersonDTO personDTO, boolean isInsert);

    PersonDTO savePerson(PersonDTO personDTO);

    PersonDTO deletePerson(PersonDTO personDTO);

    PersonDTO updatePerson(PersonDTO personDTO);
}
