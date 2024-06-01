package org.example.gamemarket.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.example.gamemarket.validation.constraint.UUIDFormatCheckerConstraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UUIDFormatCheckerConstraint.class)
public @interface UUIDFormatChecker {
    String message() default "It is not UUID format";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
