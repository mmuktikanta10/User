package com.shopping.user.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    @JsonProperty("error_name")
    private String errorName;
    @JsonProperty("error_message")
    private String errorMessage;
    private List<ErrorResponseItem> validation;
    public ErrorResponse(ErrorCode errorCode ) {
        this.errorName = errorCode.getMessage();
        this.errorMessage = errorCode.getCause();
        this.validation=null;
    }
    public ErrorResponse(ErrorCode errorCode , List<ErrorResponseItem> validation) {
        this.errorName = errorCode.getMessage();
        this.errorMessage = errorCode.getCause();
        this.validation=validation;

    }
}
