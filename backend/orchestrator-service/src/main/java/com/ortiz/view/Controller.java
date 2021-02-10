package com.ortiz.view;

import com.ortiz.com.ortiz.business.OrchestratorServiceImpl;
import com.ortiz.dto.DataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class Controller {
    @Autowired
    private OrchestratorServiceImpl service;

    @CrossOrigin(origins = "*")
    @PostMapping("/orchestrator-grpc/tenant/{tenant_id}/person")
    private DataDTO savePersonGrpc(@PathVariable(name = "tenant_id") String tenantId, @RequestBody DataDTO dataDTO) {
        dataDTO.setTenantId(tenantId);

        Optional.ofNullable(dataDTO.getPerson()).map(personDTO -> {
            personDTO.setTenantId(tenantId);
            return personDTO;
        }).orElse(null);

        dataDTO.getPerson().setTenantId(tenantId);
        Optional.ofNullable(dataDTO.getValidationFields()).map(validationFieldDTOS -> {
            validationFieldDTOS.stream().forEach(validationFieldDTO -> validationFieldDTO.setTenantId(tenantId));
            return validationFieldDTOS;
        }).orElse(null);

        return service.saveDataGrpc(dataDTO);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/orchestrator-rest/tenant/{tenant_id}/person")
    private DataDTO savePersonRest(@PathVariable(name = "tenant_id") String tenantId, @RequestBody DataDTO dataDTO) {
        dataDTO.setTenantId(tenantId);

        Optional.ofNullable(dataDTO.getPerson()).map(personDTO -> {
            personDTO.setTenantId(tenantId);
            return personDTO;
        }).orElse(null);

        dataDTO.getPerson().setTenantId(tenantId);
        Optional.ofNullable(dataDTO.getValidationFields()).map(validationFieldDTOS -> {
            validationFieldDTOS.stream().forEach(validationFieldDTO -> validationFieldDTO.setTenantId(tenantId));
            return validationFieldDTOS;
        }).orElse(null);

        return service.saveDataRest(dataDTO);
    }

}
