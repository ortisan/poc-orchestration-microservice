package com.ortiz.persistence.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
public class Field implements Serializable {
    @Id
    private String name;
}
