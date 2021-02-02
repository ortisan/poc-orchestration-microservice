package com.ortiz.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class PhysicalPerson extends Person {
    private String cpf;

}
