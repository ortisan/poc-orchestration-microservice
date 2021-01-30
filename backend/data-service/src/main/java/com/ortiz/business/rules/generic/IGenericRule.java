package com.ortiz.business.rules.generic;


import br.com.fluentvalidator.context.ValidationResult;

public interface IGenericRule<T> {
    ValidationResult validate(T object);
}
