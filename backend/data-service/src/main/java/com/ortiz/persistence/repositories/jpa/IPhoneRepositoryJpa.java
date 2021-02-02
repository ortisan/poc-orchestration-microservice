package com.ortiz.persistence.repositories.jpa;

import com.ortiz.persistence.entities.Phone;
import org.springframework.data.repository.CrudRepository;

public interface IPhoneRepositoryJpa extends CrudRepository<Phone, String> {
}
