package org.example.gamemarket.validation.constraint;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.gamemarket.validation.annotation.UUIDFormatChecker;

import java.util.Optional;
import java.util.UUID;

public class UUIDFormatCheckerConstraint implements ConstraintValidator<UUIDFormatChecker, UUID> {

    private final String UUID_PATTERN = "^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$";

    @Override
    public void initialize(UUIDFormatChecker constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UUID uuid, ConstraintValidatorContext constraintValidatorContext) {
        String id = uuid.toString();
        return Optional.ofNullable(id)
                .filter(i -> !i.isBlank())
                .map(el -> el.matches(UUID_PATTERN))
                .orElse(false);
    }
}
