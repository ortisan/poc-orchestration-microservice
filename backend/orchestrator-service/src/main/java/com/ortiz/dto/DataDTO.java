package com.ortiz.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ortiz.poc.dto.PersonDTO;
import com.ortiz.poc.dto.ValidationFieldDTO;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class DataDTO implements Serializable {
    @JsonIgnore
    private String tenantId;
    @JsonIgnore
    private String personId;
    @JsonProperty("person_data")
    private PersonDTO person;
    @JsonProperty("fields")
    private List<ValidationFieldDTO> validationFields;
}


