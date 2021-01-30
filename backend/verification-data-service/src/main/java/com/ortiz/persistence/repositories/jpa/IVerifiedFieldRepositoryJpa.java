package com.ortiz.persistence.repositories.jpa;

import com.ortiz.persistence.entities.VerifiedFieldEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface IVerifiedFieldRepositoryJpa extends CrudRepository<VerifiedFieldEntity, VerifiedFieldEntity> {
    @Query("SELECT v FROM VerifiedFieldEntity v WHERE v.id.tenantId = :tenantId AND v.id.personId = :personId")
    Collection<VerifiedFieldEntity> findByTenantAndPersonId(@Param("tenantId") String tenantId, @Param("personId") String personId);
}
