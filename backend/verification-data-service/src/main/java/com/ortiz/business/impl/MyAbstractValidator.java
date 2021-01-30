package com.ortiz.business.impl;

import br.com.fluentvalidator.AbstractValidator;
import br.com.fluentvalidator.context.ValidationContext;
import br.com.fluentvalidator.context.ValidationResult;

public abstract class MyAbstractValidator<T> extends AbstractValidator<T> {

    @Override
    public ValidationResult validate(T instance) {
        try {
            return super.validate(instance);
        } catch (Exception exc) {
            ValidationContext.remove();
            throw new RuntimeException(exc);
        }
    }
}
