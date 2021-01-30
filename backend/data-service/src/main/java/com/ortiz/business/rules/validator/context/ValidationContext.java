package com.ortiz.business.rules.validator.context;

import lombok.Builder;
import lombok.Data;

import java.util.Optional;

@Data
@Builder
public class ValidationContext<T> {
    boolean insert;
    T data;
}
