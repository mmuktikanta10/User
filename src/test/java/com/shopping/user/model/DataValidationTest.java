package com.shopping.user.model;

import com.shopping.user.model.request.UserRequestModel;
import com.shopping.user.utility.RequestAndResponseFormationUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class DataValidationTest {
    private final Validator validator= Validation.buildDefaultValidatorFactory().getValidator();
    @Test
    @DisplayName("UserRequestModel validation : positive scenario")
    public void validateUserRequestModel(){
        UserRequestModel requestModel= new RequestAndResponseFormationUtility().requestModel;
        Set<ConstraintViolation<UserRequestModel>> violation=validator.validate(requestModel);
        Assertions.assertTrue(violation.isEmpty());
    }
    @Test
    @DisplayName("UserRequestModel validation : negative scenario")
    public void validateUserRequestModelViolation(){
        UserRequestModel requestModel= new RequestAndResponseFormationUtility().requestModelWithValidationError;
        Set<ConstraintViolation<UserRequestModel>> violation=validator.validate(requestModel);
        Assertions.assertFalse(violation.isEmpty());
    }
}
