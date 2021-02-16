package com.ortiz.view;

import com.ortiz.com.ortiz.business.OrchestratorServiceImpl;
import com.ortiz.com.ortiz.business.StateEnum;
import com.ortiz.dto.DataDTO;
import com.ortiz.poc.dto.ErrorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Controller
public class ControllerWebFlux {

    @Autowired
    private OrchestratorServiceImpl service;

    @CrossOrigin(origins = "*")
    @PostMapping("/orchestrator-grpc-webflux/tenant/{tenant_id}/person")
    public Mono<ResponseEntity> savePersonGrpc(@PathVariable(name = "tenant_id") String tenantId, @RequestBody DataDTO dataDTO) {
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

        return service.saveDataGrpcMono(dataDTO)
                .flatMap(data -> {
                    if (data.getState() == StateEnum.DONE) {
                        ResponseEntity body = ResponseEntity.status(HttpStatus.CREATED).body(data);
                        return Mono.just(body);
                    } else if(data.getState() == StateEnum.UNDONE) {
                        ErrorDTO errorDTO = ErrorDTO.builder().message("Rollback successfully...").build();
                        ResponseEntity body = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDTO);
                        return Mono.just(body);
                    } else {
                        ErrorDTO errorDTO = ErrorDTO.builder().message("The process was in an inconsistent state. We will try again later...").build();
                        ResponseEntity body = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDTO);
                        return Mono.just(body);
                    }
                })
                .onErrorResume(exc -> {
                    ErrorDTO errorDTO = ErrorDTO.builder().message(exc.getMessage()).cause(exc.getCause()).build();
                    ResponseEntity body = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDTO);
                    return Mono.just(body);
                });
    }
}
