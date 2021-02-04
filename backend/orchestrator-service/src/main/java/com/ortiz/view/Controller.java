package com.ortiz.view;

import com.ortiz.com.ortiz.business.OrchestratorServiceImpl;
import com.ortiz.dto.DataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private OrchestratorServiceImpl service;

    @PostMapping("/tenant/{tenant_id}/person")
    private DataDTO savePerson(@PathVariable(name = "tenant_id") String tenantId, @RequestBody DataDTO dataDTO) {
        dataDTO.setTenantId(tenantId);
        return service.saveData(dataDTO);
    }
}
