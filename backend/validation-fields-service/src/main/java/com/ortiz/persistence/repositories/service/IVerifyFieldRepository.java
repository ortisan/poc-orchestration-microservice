package com.ortiz.persistence.repositories.service;

import com.ortiz.domain.VerifiedFieldDomain;

import java.util.List;

public interface IVerifyFieldRepository {
    List<VerifiedFieldDomain> getVerifiedFieldsByPerson(String tenantId, String personId);

    List<VerifiedFieldDomain> saveVerifiedFields(List<VerifiedFieldDomain> fields);

    List<VerifiedFieldDomain> updateVerifiedFields(List<VerifiedFieldDomain> fields);
}
