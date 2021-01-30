package com.ortiz.persistence.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Data
@Entity
public class Phone {
    @Id
    private String id;
    private Integer ddi;
    private Integer ddd;
    private Integer number;
    private Integer extensionLine;
}
