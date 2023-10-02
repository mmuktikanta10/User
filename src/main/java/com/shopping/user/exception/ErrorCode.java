package com.shopping.user.exception;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
public enum ErrorCode {
    DUPLICATE_INPUT("Duplicate data", "Input data already exists"),
    USER_NOT_FOUND("UserNotFound", "User not registered with us.Please check the email or register "),
    UNRECOGNIZED_PROPERTY_IN_REQUEST_BODY("InvalidProperty", "This Property is not part of the request body"), FIELD_ERROR("FieldError", "Field values are not correct");
    private final String message;
    private final String cause;

    ErrorCode(String message, String cause) {
        this.message = message;
        this.cause = cause;
    }
}
