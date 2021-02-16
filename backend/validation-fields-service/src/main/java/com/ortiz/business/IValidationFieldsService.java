package com.ortiz.business;


import com.ortiz.poc.dto.ValidationFieldDTO;

import java.util.List;

public interface IValidationFieldsService {
    List<ValidationFieldDTO> getValidatedFields(String tenantId, String personId);

    List<ValidationFieldDTO> saveVerifiedFields(List<ValidationFieldDTO> validationFieldDTOS);

    List<ValidationFieldDTO> deleteSavedVerifiedFields(List<ValidationFieldDTO> validationFieldDTOS);

    List<ValidationFieldDTO> updateVerifiedFields(List<ValidationFieldDTO> validationFieldDTOS);

    List<ValidationFieldDTO> validateFields(List<ValidationFieldDTO> validationFieldDTOS);
}
