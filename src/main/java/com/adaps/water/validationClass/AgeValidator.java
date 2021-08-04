package com.adaps.water.validationClass;

import com.adaps.water.validationRules.Age;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<Age, Integer> {
    private static final int minAge = 1;
    private static final int maxAge = 100;

    @Override
    public boolean isValid(Integer age, ConstraintValidatorContext context) {
        return age >= minAge && age <= maxAge;
    }
}
