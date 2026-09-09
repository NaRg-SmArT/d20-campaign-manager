package com.mhosler.d20_campaign_manager.security;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {

    public boolean isValid(String value, ConstraintValidatorContext context ) {
        return value.length() >= 8 && value.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*]).+$");
    }
}
