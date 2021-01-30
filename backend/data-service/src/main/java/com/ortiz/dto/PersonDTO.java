package com.ortiz.dto;


import lombok.Data;

import java.util.List;

@Data
public class PersonDTO {
    private String tenantId;
    private String id;
    private String name;
    private String type;
    private String cpf_cnpj;
    private List<PhoneDTO> phones;
}
