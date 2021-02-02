package com.ortiz.business.rules;

import br.com.fluentvalidator.context.ValidationResult;
import com.ortiz.domain.Person;

public interface IPersonRule {

    ValidationResult validate(Person person, boolean isInsert);
}
