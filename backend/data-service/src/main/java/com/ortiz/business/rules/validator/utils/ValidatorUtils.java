package com.ortiz.business.rules.validator.utils;

import br.com.fluentvalidator.context.Error;
import br.com.fluentvalidator.context.ValidationResult;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ValidatorUtils {
    public static ValidationResult combine(ValidationResult... results) {
        List<Error> errors = Arrays.stream(results).flatMap(result -> result.getErrors().stream()).collect(Collectors.toList());
        boolean isValid = errors.isEmpty();
        if (isValid) {
            return ValidationResult.ok();
        }
        return ValidationResult.fail(errors);
    }
}
