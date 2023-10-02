package com.shopping.user.exception;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GlobalExceptionHandlerTest {
    @InjectMocks
    GlobalExceptionHandler globalExceptionHandler;

    @Mock
    MethodArgumentNotValidException exception;

    @Mock
    BindingResult bindingResult;


    @Test
    @DisplayName("When throws DataIntegrityViolationException test")
    void handleDataIntegrityViolationExceptionTest() {
       /* doReturn("Input data already exists").when(errorResponse).getErrorMessage();
        doReturn("Duplicate data").when(errorResponse).getErrorName();*/
        ResponseEntity<ErrorResponse> handle = globalExceptionHandler.handle(new DataIntegrityViolationException(""));
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, handle.getStatusCode());
       /* ErrorResponse ErrorResponse = new ErrorResponse(ErrorCode.DUPLICATE_INPUT);
        Assertions.assertEquals(ErrorResponse.getErrorName(),handle.getBody().getErrorName());
        Assertions.assertEquals(ErrorResponse.getErrorMessage(),handle.getBody().getErrorMessage());*/
    }

    @Test
    @DisplayName("When throws UserNotFoundException test")
    void testHandleUserNotFoundExceptionTest() {
        ResponseEntity<ErrorResponse> handle = globalExceptionHandler.handle(new UserNotFoundException(""));
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, handle.getStatusCode());
    }

    @Test
    @DisplayName("When throws UnrecognizedPropertyException test")
    void testHandleUnrecognizedPropertyExceptionTest() {
        UnrecognizedPropertyException unrecognizedPropertyException = mock(UnrecognizedPropertyException.class);
        ResponseEntity<ErrorResponse> handle = globalExceptionHandler.handle(unrecognizedPropertyException);
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, handle.getStatusCode());
    }

    @Disabled
    @Test
    @DisplayName("When throws MethodArgumentNotValidException test")
    void testHandleMethodArgumentNotValidExceptionTest() {
        FieldError fieldError1 = new FieldError("fieldName1", "message1", "message 1");
        FieldError fieldError2 = new FieldError("fieldName2", "message2", "message 2");
        List<FieldError> validationErrors = Arrays.asList(fieldError1, fieldError2);
        when(exception.getBindingResult()).thenReturn(bindingResult);
        when(bindingResult.getFieldErrors()).thenReturn(validationErrors);
        ResponseEntity<ErrorResponse> handle = globalExceptionHandler.handle(exception);
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, handle.getStatusCode());
    }
}