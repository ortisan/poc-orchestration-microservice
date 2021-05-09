package com.ortiz.poc.dto;

import com.ortiz.poc.fields.FieldTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class FieldDTO {
    private String name;
    private Object value;
    private FieldTypeEnum type;
    private Boolean critical;
}
