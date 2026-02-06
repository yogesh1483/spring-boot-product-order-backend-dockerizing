package com.spring.app.exception;

public class BusinessValidationException extends ApplicationException{
    public BusinessValidationException(String message) {
        super(message, "BUSINESS_VALIDATION_ERROR");
    }
}
