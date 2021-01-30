package com.ortiz.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class CorporatePerson extends Person {
    private String cnpj;
}
