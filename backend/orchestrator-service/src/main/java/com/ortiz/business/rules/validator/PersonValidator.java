package com.ortiz.business.rules.validator;

import br.com.fluentvalidator.AbstractValidator;
import br.com.fluentvalidator.context.ValidationContext;
import com.ortiz.business.rules.validator.utils.PredicatesUtils;
import com.ortiz.domain.Person;

import java.util.Objects;
import java.util.Optional;

import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;
import static br.com.fluentvalidator.predicate.StringPredicate.stringSizeBetween;

public abstract class PersonValidator<P extends Person> extends AbstractValidator<P> {

    @Override
    public void rules() {
        setPropertyOnContext(this.getClass().getName());

        // Rule for insert
        ruleFor((P p) -> Optional.ofNullable(p.getPersonIdentity()).map(personIdentity -> personIdentity.getId()).orElseGet(() -> null))
                .must(stringEmptyOrNull())
                .when(s -> {
                    Person person = getPropertyOnContext(this.getClass().getName(), Person.class);
                    return person.isInsert();
                })
                .withMessage("Person must not have id in this operation")
                .critical();

        // Rule for update
        ruleFor((P p) -> p.getPersonIdentity().getId())
                .must(not(stringEmptyOrNull()))
                .when(s -> {
                    Person person = getPropertyOnContext(this.getClass().getName(), Person.class);
                    return !person.isInsert();
                })
                .withMessage("Person Id is required")
                .critical();

        ruleFor(Person::getTenantId)
                .must(not(stringEmptyOrNull()))
                .withMessage("Tenant Id is required")
                .critical();

        ruleFor(Person::getFullName)
                .must(not(stringEmptyOrNull()))
                .withMessage("Name is required")
                .must(stringSizeBetween(3, 120))
                .withMessage("Name must be lengh between 3 and 120 chars")
                .critical();

        ruleFor(Person::getPersonType)
                .must(not(Objects::isNull))
                .withMessage("Person type is required")
                .critical();
    }
}

