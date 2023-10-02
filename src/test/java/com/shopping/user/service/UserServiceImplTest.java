package com.shopping.user.service;

import com.shopping.user.entity.UserEntity;
import com.shopping.user.exception.UserNotFoundException;
import com.shopping.user.model.response.UserResponseModel;
import com.shopping.user.repository.UserRepository;
import com.shopping.user.utility.RequestAndResponseFormationUtility;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @InjectMocks
    UserServiceImpl userService;

    @Mock
    UserRepository userRepository;
    @Mock
    ModelMapper modelMapper;
    RequestAndResponseFormationUtility requestAndResponseFormationUtility;
    @BeforeEach
    public void initialize(){
        requestAndResponseFormationUtility=new RequestAndResponseFormationUtility();
    }

    @Test
    @DisplayName("User service register test : Success scenario")
    void registerUserSuccessTest() {
        when(modelMapper.map(requestAndResponseFormationUtility.requestModel, UserEntity.class)).thenReturn(requestAndResponseFormationUtility.userEntity);
        when(userRepository.save(requestAndResponseFormationUtility.userEntity)).thenReturn(requestAndResponseFormationUtility.userEntity);
        when(modelMapper.map(eq(Optional.ofNullable(requestAndResponseFormationUtility.userEntity)), eq(UserResponseModel.class))).thenReturn(requestAndResponseFormationUtility.responseModel);
        Optional<UserResponseModel> userResponseModel = userService.registerUser(requestAndResponseFormationUtility.requestModel);
        Assertions.assertNotNull(userResponseModel.get());
        Assertions.assertEquals(requestAndResponseFormationUtility.responseModel.toString(),userResponseModel.get().toString());
    }
    @Test
    @DisplayName("User service register test : negative scenario")
    void registerUserFailureWithExceptionTest() {
        when(modelMapper.map(requestAndResponseFormationUtility.requestModel, UserEntity.class)).thenReturn(requestAndResponseFormationUtility.userEntity);
        when(userRepository.save(requestAndResponseFormationUtility.userEntity)).thenThrow(DataIntegrityViolationException.class);
        Assertions.assertThrows(DataIntegrityViolationException.class,()->userService.registerUser(requestAndResponseFormationUtility.requestModel));
    }

    @Test
    @DisplayName("User service search test : Success scenario")
    void searchUserSuccessTest() {
        when(userRepository.findByEmail("dummy@gmail.com")).thenReturn(Optional.of(requestAndResponseFormationUtility.userEntity));
        when(modelMapper.map(Optional.of(requestAndResponseFormationUtility.userEntity),UserResponseModel.class)).thenReturn(requestAndResponseFormationUtility.responseModel);
        Optional<UserResponseModel> userResponseModel = userService.searchUser("dummy@gmail.com");
        Assertions.assertEquals("dummy@gmail.com",userResponseModel.get().getEmail());
    }
    @Test
    @DisplayName("User service search test : User not found scenario")
    void searchUserFailureWithUserNotFoundTest() {
        when(userRepository.findByEmail("dummy@gmail.com")).thenReturn(Optional.empty());
        Assertions.assertThrows(UserNotFoundException.class,()->userService.searchUser("dummy@gmail.com"));
    }
}