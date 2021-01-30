package com.ortiz.persistence.entities;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Corporate extends Person {
    private String cnpj;
}
