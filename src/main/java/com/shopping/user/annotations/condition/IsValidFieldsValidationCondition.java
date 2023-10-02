package com.shopping.user.annotations.condition;

import com.shopping.user.annotations.IsValidFields;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.NotNull;
import java.util.Map;
import java.util.Set;
@Component
public class IsValidFieldsValidationCondition implements ConstraintValidator<IsValidFields, Map<String, String>> {
    @Override
    public boolean isValid(Map<String, String> value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // Validation is not applicable
        }

        Set<String> allowedFields = Set.of("shippingAddress", "billingAddress", "field3"); // Define your allowed fields here

        // Check if all provided fields are in the allowedFields set
        return allowedFields.containsAll(value.keySet());

    }


}
