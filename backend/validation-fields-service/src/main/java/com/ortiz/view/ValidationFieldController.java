package com.ortiz.view;

import com.ortiz.business.IValidationFieldsService;
import com.ortiz.poc.dto.ValidationFieldDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ValidationFieldController {

    @Autowired
    private IValidationFieldsService verifiedFieldsService;

    @GetMapping("/tenant/{tenant_id}/person/{person_id}/fields")
    private List<ValidationFieldDTO> getFields(@PathVariable(name = "tenant_id") String tenantId, @PathVariable(name = "person_id") String personId) {
        return verifiedFieldsService.getValidatedFields(tenantId, personId);
    }

    @PostMapping("/tenant/{tenant_id}/person/{person_id}/fields")
    private List<ValidationFieldDTO> saveFields(@PathVariable(name = "tenant_id") String tenantId, @PathVariable(name = "person_id") String personId, @RequestBody List<ValidationFieldDTO> verifiedFields) {
        List<ValidationFieldDTO> listWithTenantAndPersonId = verifiedFields.stream().map(verifiedFieldDTO -> {
            verifiedFieldDTO.setTenantId(tenantId);
            verifiedFieldDTO.setPersonId(personId);
            return verifiedFieldDTO;
        }).collect(Collectors.toList());
        return verifiedFieldsService.saveVerifiedFields(listWithTenantAndPersonId);
    }

    @PostMapping("/validation/tenant/{tenant_id}/fields")
    private List<ValidationFieldDTO> validationSaveFields(@PathVariable(name = "tenant_id") String tenantId, @RequestBody List<ValidationFieldDTO> verifiedFields) {
        List<ValidationFieldDTO> listWithTenantAndPersonId = verifiedFields.stream().map(verifiedFieldDTO -> {
            verifiedFieldDTO.setTenantId(tenantId);
            return verifiedFieldDTO;
        }).collect(Collectors.toList());
        return verifiedFieldsService.validateFields(listWithTenantAndPersonId);
    }
}
