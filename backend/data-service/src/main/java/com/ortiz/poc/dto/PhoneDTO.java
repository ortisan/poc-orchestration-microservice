package com.ortiz.poc.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PhoneDTO {
    @JsonIgnore
    private String tenandId;
    @JsonIgnore
    private String personId;
    private String id;
    private Integer ddi;
    private Integer ddd;
    private Integer number;
    @JsonProperty("extension_line")
    private Integer extensionLine;
}
