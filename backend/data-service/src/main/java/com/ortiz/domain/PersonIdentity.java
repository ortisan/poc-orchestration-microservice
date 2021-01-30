package com.ortiz.domain;

import lombok.Data;

@Data
public class PersonIdentity {
    private String id;
    private DocumentTypeEnum documentType;
    private String documentNumber;
    private String countryCode;
}
