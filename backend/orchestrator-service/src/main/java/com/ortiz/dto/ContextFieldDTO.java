package com.ortiz.dto;

import com.ortiz.poc.dto.FieldDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ContextFieldDTO extends FieldDTO {
    private ContextFlowDTO context;
}
