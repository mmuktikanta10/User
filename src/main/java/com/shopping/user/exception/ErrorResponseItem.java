package com.shopping.user.exception;

import lombok.Data;

import java.util.Comparator;
@Data
public class ErrorResponseItem {
    private final String errorName;
    private final String errorMessage;
    private final String jsonPath;

    private final PathType pathType;
    public enum PathType{JSON_PATH}
    public ErrorResponseItem(ErrorCode errorCode, String jsonPath, PathType pathType) {
        this.errorName = errorCode.getMessage();
        this.errorMessage = errorCode.getCause();
        this.jsonPath = jsonPath;
        this.pathType = pathType;
    }

}
