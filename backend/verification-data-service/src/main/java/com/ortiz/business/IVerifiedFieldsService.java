package com.ortiz.business;

import com.ortiz.dto.VerifiedFieldDTO;

import java.util.List;

public interface IVerifiedFieldsService {
    List<VerifiedFieldDTO> getFields(String tenantId, String personId);

    List<VerifiedFieldDTO> saveFields(List<VerifiedFieldDTO> verifiedFieldDTOS);

    List<VerifiedFieldDTO> updateFields(List<VerifiedFieldDTO> verifiedFieldDTOS);
}
