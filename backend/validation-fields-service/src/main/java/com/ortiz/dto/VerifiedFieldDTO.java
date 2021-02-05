package com.ortiz.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
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
    private String cause;
    @JsonProperty("server_validated")
    private Boolean serverValidated;
}
