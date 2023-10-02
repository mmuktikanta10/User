package com.shopping.user.controller;

import com.shopping.user.exception.UserNotFoundException;
import com.shopping.user.model.response.UserResponseModel;
import com.shopping.user.service.UserService;
import com.shopping.user.utility.RequestAndResponseFormationUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {
    @InjectMocks
    UserController userController;
    @Mock
    UserService userService;
    RequestAndResponseFormationUtility requestAndResponseFormationUtility;

    @BeforeEach
    void initialize() {
        requestAndResponseFormationUtility = new RequestAndResponseFormationUtility();
    }

    @Test
    @DisplayName("User registration test : success scenario")
    void registerUserSuccessTest() {
        when(userService.registerUser(requestAndResponseFormationUtility.requestModel)).thenReturn(Optional.of(requestAndResponseFormationUtility.responseModel));
        ResponseEntity<UserResponseModel> register = userController.register(requestAndResponseFormationUtility.requestModel);
        Assertions.assertEquals(200, register.getStatusCodeValue());
        Assertions.assertEquals(requestAndResponseFormationUtility.responseModel.toString(), register.getBody().toString());
    }
    @Test
    @DisplayName("User registration test : duplicate user scenario")
    void registerUserWithDuplicateUserTest() {
        when(userService.registerUser(requestAndResponseFormationUtility.requestModel)).thenThrow(DataIntegrityViolationException.class);
        Assertions.assertThrows(DataIntegrityViolationException.class,()->userController.register(requestAndResponseFormationUtility.requestModel));
    }

    @Test
    @DisplayName("User search test : success scenario")
    void findUserSuccessTesT(){
        when(userService.searchUser("demo@gmail.com")).thenReturn(Optional.of(requestAndResponseFormationUtility.responseModel));
        ResponseEntity<UserResponseModel> searchedUser=userController.findUser("demo@gmail.com");
        Assertions.assertEquals(200,searchedUser.getStatusCodeValue());
    }
    @Test
    @DisplayName("User search test : user not found scenario")
    void findUserUserNotFoundExceptionTest(){
        when(userService.searchUser("demo@gmail.com")).thenThrow(UserNotFoundException.class);
        Assertions.assertThrows(UserNotFoundException.class,()->userController.findUser("demo@gmail.com"));
    }
}