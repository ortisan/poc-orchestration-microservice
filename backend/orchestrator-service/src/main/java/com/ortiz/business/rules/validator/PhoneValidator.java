package com.ortiz.business.rules.validator;

import br.com.fluentvalidator.AbstractValidator;
import br.com.fluentvalidator.context.ValidationContext;
import com.ortiz.domain.Phone;
import org.springframework.stereotype.Component;

import static br.com.fluentvalidator.predicate.ComparablePredicate.between;
import static br.com.fluentvalidator.predicate.ObjectPredicate.nullValue;
import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;
import static java.util.function.Predicate.not;

@Component
public class PhoneValidator extends AbstractValidator<Phone> {

    private static String PROPERTY_NAME = PhoneValidator.class.getName();

    @Override
    public void rules() {
        setPropertyOnContext(PROPERTY_NAME);

        ruleFor(phone -> phone.getId())
                .must(stringEmptyOrNull())
                .when(s -> {
                    Phone phone = getPropertyOnContext(PROPERTY_NAME, Phone.class);
                    return phone.isInsert();
                })
                .withMessage("Phone Id must be empty")
                .critical();

        ruleFor(phone -> phone.getId())
                .must(stringEmptyOrNull())
                .when(s -> {
                    Phone phone = getPropertyOnContext(PROPERTY_NAME, Phone.class);
                    return !phone.isInsert();
                })
                .withMessage("Phone Id is required")
                .critical();

        ruleFor(Phone::getDdi)
                .must(not(nullValue()))
                .withMessage("DDI is required")
                .must(between(1, 999))
                .withMessage("DDI invalid")
                .critical();

        ruleFor(Phone::getDdd)
                .must(not(nullValue()))
                .withMessage("DDD is required")
                .must(between(1, 999))
                .withMessage("DDD invalid")
                .critical();

        ruleFor(Phone::getNumber)
                .must(not(nullValue()))
                .withMessage("Phone number is required")
                .critical();
    }
}

