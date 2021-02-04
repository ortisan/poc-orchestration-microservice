package com.ortiz.persistence.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Person {
    @EmbeddedId
    private PersonId personId;
    private String type;
    private String name;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Phone> phones;
}
