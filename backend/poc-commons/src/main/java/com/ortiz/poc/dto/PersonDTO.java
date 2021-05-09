package com.ortiz.poc.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ortiz.poc.fields.FieldProcessor;
import com.ortiz.poc.fields.FieldTypeEnum;
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
    @FieldProcessor(fieldName = "PERSON_NAME", fieldType = FieldTypeEnum.SINGLE, isCritical = true)
    private String name;
    @FieldProcessor(fieldName = "PERSON_TYPE", fieldType = FieldTypeEnum.SINGLE)
    private String type;
    @FieldProcessor(fieldName = "CPF_CNPJ", fieldType = FieldTypeEnum.SINGLE)
    @JsonProperty("cpf_cnpj")
    private String cpfCnpj;
    @FieldProcessor(fieldName = "CPF_CNPJ", fieldType = FieldTypeEnum.MULTIPLE_PHONE)
    private List<PhoneDTO> phones;
}
