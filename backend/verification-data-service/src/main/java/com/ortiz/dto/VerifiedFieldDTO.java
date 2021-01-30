package com.ortiz.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class VerifiedFieldDTO {
    private Long id;
    @JsonIgnore
    private String tenantId;
    @JsonIgnore
    private String personId;
    @JsonProperty("field_name")
    private String fieldName;
    private String value;
    private Integer level;
    private Boolean validated;
    @JsonProperty("created_date")
    private LocalDateTime createdDate;
}
