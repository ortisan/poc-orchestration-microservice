package com.ortiz.persistence.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "verified_field")
public class VerifiedFieldEntity implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "name")
    private Field field;
    @Column(name = "tenant_id", nullable = false, updatable = false)
    private String tenantId;
    @Column(name = "person_id", nullable = false, updatable = false)
    private String personId;
    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDateTime createdDate;
    private String value;
    private Integer level;
    private Boolean validated;
}
