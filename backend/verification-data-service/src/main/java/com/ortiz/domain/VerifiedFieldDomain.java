package com.ortiz.domain;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class VerifiedFieldDomain implements Serializable {
    private Long id;
    private String tenantId;
    private String personId;
    private String fieldName;
    private LocalDateTime createdDate;
    private String value;
    private Integer level;
    private Boolean validated;
}
