package org.example.gamemarket.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.example.gamemarket.constraint.UUIDFormatCheckerConstraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UUIDFormatCheckerConstraint.class)
public @interface UUIDFormatChecker {
    String message() default "IT IS WRONG FORMAT";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
