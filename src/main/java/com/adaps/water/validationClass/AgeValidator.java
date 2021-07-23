package com.adaps.water.validationClass;

import com.adaps.water.validationRules.Age;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<Age, String> {
    private static final int minAge = 1;

    @Override
    public boolean isValid(String age, ConstraintValidatorContext context) {
        return Integer.parseInt(age) > minAge;
    }
}
