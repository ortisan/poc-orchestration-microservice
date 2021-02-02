package com.ortiz.persistence.repositories.jpa;

import com.ortiz.domain.DocumentTypeEnum;
import com.ortiz.persistence.entities.PersonIdentity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface IPersonIdentityRepositoryJpa extends CrudRepository<PersonIdentity, String> {

    @Query("SELECT pi FROM PersonIdentity pi WHERE pi.documentType = :documentType AND pi.documentNumber = :documentNumber")
    Collection<PersonIdentity> findByDocumentTypeAndNumber(@Param("documentType") DocumentTypeEnum documentType, @Param("documentNumber") String documentNumber);
}
