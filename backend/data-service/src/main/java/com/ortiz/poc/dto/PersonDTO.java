package com.ortiz.poc.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
