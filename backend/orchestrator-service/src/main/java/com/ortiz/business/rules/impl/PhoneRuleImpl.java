package com.ortiz.business.rules.impl;

import br.com.fluentvalidator.context.ValidationResult;
import com.ortiz.business.rules.IPhoneRule;
import com.ortiz.business.rules.validator.PhoneValidator;
import com.ortiz.business.rules.validator.utils.ValidatorUtils;
import com.ortiz.domain.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class PhoneRuleImpl implements IPhoneRule {

    @Autowired
    private PhoneValidator phoneValidator;

    @Override
    public ValidationResult validate(Collection<Phone> phones) {
        Optional<ValidationResult> validationResult = phones.stream().map((phone -> validate(phone))).reduce((result1, result2) -> ValidatorUtils.combine(result1, result2));
        return validationResult.get();
    }

    @Override
    public ValidationResult validate(Phone phone) {
        return phoneValidator.validate(phone);
    }
}
