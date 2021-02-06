package com.ortiz.view;

import com.ortiz.business.IPhoneService;
import com.ortiz.poc.dto.PhoneDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PhoneController {

    @Autowired
    private IPhoneService phoneService;

    @PostMapping("/tenant/{tenant_id}/person/{person_id}/phones")
    private PhoneDTO updatePerson(@PathVariable(name = "tenant_id") String tenantId, @PathVariable(name = "person_id") String personId, @RequestBody PhoneDTO phoneDTO) {
        phoneDTO.setTenandId(tenantId);
        phoneDTO.setPersonId(personId);
        return phoneService.savePhone(phoneDTO);
    }

    @PutMapping("/tenant/{tenant_id}/person/{person_id}/phones/{phone_id}")
    private PhoneDTO updatePerson(@PathVariable(name = "tenant_id") String tenantId, @PathVariable(name = "person_id") String personId, @PathVariable(name = "phone_id") String phoneId, @RequestBody PhoneDTO phoneDTO) {
        phoneDTO.setTenandId(tenantId);
        phoneDTO.setPersonId(personId);
        return phoneService.updatePhone(phoneDTO);
    }
}
