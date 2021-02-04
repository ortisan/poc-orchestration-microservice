package com.ortiz.business;

import com.ortiz.dto.VerifiedFieldDTO;

import java.util.List;
import java.util.stream.Collectors;

public interface IValidationFieldsService {
    List<VerifiedFieldDTO> getVerifiedFields(String tenantId, String personId);

    List<VerifiedFieldDTO> saveVerifiedFields(List<VerifiedFieldDTO> verifiedFieldDTOS);

    List<VerifiedFieldDTO> updateVerifiedFields(List<VerifiedFieldDTO> verifiedFieldDTOS);

    List<VerifiedFieldDTO> validateFields(List<VerifiedFieldDTO> verifiedFieldDTOS);
}
