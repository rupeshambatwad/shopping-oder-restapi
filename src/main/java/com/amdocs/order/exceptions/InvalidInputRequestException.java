package com.amdocs.order.exceptions;

public class InvalidInputRequestException extends RuntimeException {
    private String errorCode;
    private String errorMessage;

    public InvalidInputRequestException() {

    }
    public InvalidInputRequestException(String errorCode, String errorMessage) {
        super(errorCode +"Invalid input request for"+errorMessage);
    }
}
