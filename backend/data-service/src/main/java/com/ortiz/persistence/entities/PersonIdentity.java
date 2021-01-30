package com.ortiz.persistence.entities;

import com.ortiz.domain.DocumentTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PersonIdentity {
    @Id
    private String id;
    private DocumentTypeEnum documentType;
    private String documentNumber;
    private String countryCode;
}
