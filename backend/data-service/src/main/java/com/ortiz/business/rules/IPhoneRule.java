package com.ortiz.business.rules;

import br.com.fluentvalidator.context.ValidationResult;
import com.ortiz.domain.Phone;

import java.util.Collection;

public interface IPhoneRule {
    ValidationResult validate(Collection<Phone> phones);
    ValidationResult validate(Phone phone);
}
