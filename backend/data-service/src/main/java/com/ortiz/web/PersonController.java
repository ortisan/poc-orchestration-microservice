package com.ortiz.web;

import com.ortiz.business.IPersonService;
import com.ortiz.dto.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {

    @Autowired
    private IPersonService personService;

    @GetMapping("/tenant/{tenant_id}/person/{person_id}")
    private PersonDTO getPerson(@PathVariable(name = "tenant_id") String tenantId, @PathVariable(name = "person_id") String personId) {
        return personService.getPerson(tenantId, personId);
    }

    @PostMapping("/tenant/{tenant_id}/person")
    private PersonDTO savePerson(@PathVariable(name = "tenant_id") String tenantId, @RequestBody PersonDTO personDTO) {
        personDTO.setTenantId(tenantId);
        return personService.savePerson(personDTO);
    }

    @PutMapping("/tenant/{tenant_id}/person/{person_id}")
    private PersonDTO updatePerson(@PathVariable(name = "tenant_id") String tenantId, @PathVariable(name = "person_id") String personId, @RequestBody PersonDTO personDTO) {
        personDTO.setTenantId(tenantId);
        personDTO.setId(personId);
        return personService.updatePerson(personDTO);
    }
}
