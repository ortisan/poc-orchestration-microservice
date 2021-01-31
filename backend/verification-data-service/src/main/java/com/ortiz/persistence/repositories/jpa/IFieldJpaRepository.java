package com.ortiz.persistence.repositories.jpa;

import com.ortiz.persistence.entities.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IFieldJpaRepository extends JpaRepository<Field, String> {
}
