package com.ortiz.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PersonDTO {
    @JsonIgnore
    private String tenantId;
    private String id;
    private String name;
    private String type;
    @JsonProperty("cpf_cnpj")
    private String cpfCnpj;
    private List<PhoneDTO> phones;
}
