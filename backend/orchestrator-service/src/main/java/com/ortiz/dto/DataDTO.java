package com.ortiz.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.ortiz.com.ortiz.business.StateEnum;
import com.ortiz.poc.dto.PersonDTO;
import com.ortiz.poc.dto.ValidationFieldDTO;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@JsonPropertyOrder({"transaction_id", "state", "person_date", "fields"})
public class DataDTO implements Serializable {
    @JsonIgnore
    private String tenantId;
    @JsonIgnore
    private String personId;
    @JsonProperty("transaction_id")
    private String transactionId;
    private StateEnum state;
    @JsonProperty("person_data")
    private PersonDTO person;
    @JsonProperty("fields")
    private List<ValidationFieldDTO> validationFields;
}


