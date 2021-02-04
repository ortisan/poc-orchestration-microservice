package com.ortiz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;
import java.util.List;

import java.io.Serializable;

@Data
public class DataDTO implements Serializable {
    @JsonIgnore
    private String tenantId;
    @JsonIgnore
    private String personId;
    @JsonProperty("person_data")
    private PersonDTO person;

    private List<VerifiedFieldDTO> verifiedFields;


}


