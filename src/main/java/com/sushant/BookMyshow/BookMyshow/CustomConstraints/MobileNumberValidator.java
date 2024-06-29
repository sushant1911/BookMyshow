package com.sushant.BookMyshow.BookMyshow.CustomConstraints;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MobileNumberValidator implements ConstraintValidator<ValidMobileNumber,Integer> {
    @Override
    public void initialize(ValidMobileNumber constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return false;
        }
        String valueAsString = String.valueOf(value);
        return valueAsString.matches("\\d{10}");
    }
}
