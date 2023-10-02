package com.shopping.user.annotations;

import com.shopping.user.annotations.condition.IsValidFieldsValidationCondition;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.PARAMETER,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = IsValidFieldsValidationCondition.class)
public @interface IsValidFields {
    String message() default "Invalid field provided.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
