package com.spring.app.exception;

public class BadRequestException extends ApplicationException{
    public BadRequestException(String message) {
        super(message, "BAD_REQUEST");
    }
}
