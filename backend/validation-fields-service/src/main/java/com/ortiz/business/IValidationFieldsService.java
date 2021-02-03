package com.ortiz.business;

import com.ortiz.dto.VerifiedFieldDTO;

import java.util.List;

public interface IValidationFieldsService {
    List<VerifiedFieldDTO> getVerifiedFields(String tenantId, String personId);

    List<VerifiedFieldDTO> saveVerifiedFields(List<VerifiedFieldDTO> verifiedFieldDTOS);

    List<VerifiedFieldDTO> updateVerifiedFields(List<VerifiedFieldDTO> verifiedFieldDTOS);
}
