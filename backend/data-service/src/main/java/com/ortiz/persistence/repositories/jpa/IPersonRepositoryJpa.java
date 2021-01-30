package com.ortiz.persistence.repositories.jpa;

import com.ortiz.persistence.entities.Person;
import com.ortiz.persistence.entities.PersonId;
import org.springframework.data.repository.CrudRepository;

public interface IPersonRepositoryJpa extends CrudRepository<Person, PersonId> {
}
