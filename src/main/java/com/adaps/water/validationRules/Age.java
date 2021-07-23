package com.adaps.water.validationRules;

import com.adaps.water.validationClass.AgeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AgeValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Age {
    String message() default "Invalid age";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
