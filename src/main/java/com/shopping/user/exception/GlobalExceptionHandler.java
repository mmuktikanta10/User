package com.shopping.user.exception;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {
    private ErrorResponse errorResponse;

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handle(final DataIntegrityViolationException exception) {
        errorResponse = new ErrorResponse(ErrorCode.DUPLICATE_INPUT);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handle(final UserNotFoundException exception) {
        errorResponse = new ErrorResponse(ErrorCode.USER_NOT_FOUND);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handle(final UnrecognizedPropertyException exception) {
        errorResponse = new ErrorResponse(ErrorCode.UNRECOGNIZED_PROPERTY_IN_REQUEST_BODY);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handle(final MethodArgumentNotValidException exception) {
        errorResponse = new ErrorResponse(ErrorCode.FIELD_ERROR,formErrorResponseItems(exception.getBindingResult().getFieldErrors()));
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    private List<ErrorResponseItem> formErrorResponseItems(List<FieldError> validationErrors) {
        return validationErrors.stream().map(this::getErrorItem).collect(Collectors.toList());
    }

    private ErrorResponseItem getErrorItem(FieldError fieldError) {
        return new ErrorResponseItem(ErrorCode.FIELD_ERROR, fieldError.getField(), ErrorResponseItem.PathType.JSON_PATH);

    }

}
