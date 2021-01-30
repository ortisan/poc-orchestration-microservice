package com.ortiz.business.rules.validator.utils;

import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.fluentvalidator.predicate.PredicateBuilder;
import org.apache.commons.validator.routines.EmailValidator;

import java.util.function.Predicate;

import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.ObjectPredicate.nullValue;

public class PredicatesUtils {
    public static Predicate<String> isCPFValid = cpf -> new CPFValidator().invalidMessagesFor(cpf).isEmpty();
    public static Predicate<String> isCNPJValid = cnpj -> new CNPJValidator().invalidMessagesFor(cnpj).isEmpty();
    public static Predicate<String> isEmailValid = email -> EmailValidator.getInstance().isValid(email);

    public static Predicate<Integer> integerBetween(final Integer min, final Integer max) {
        return PredicateBuilder.<Integer>from(not(nullValue())).and(n -> {
            return n >= min && n <= max;
        });
    }
}
