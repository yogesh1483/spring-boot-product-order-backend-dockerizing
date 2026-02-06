package com.spring.app.exception;

public class ResourceNotFoundException extends ApplicationException {
    public ResourceNotFoundException(String resource, Object id) {
        super(
                resource + " not found with id: " + id,
                "RESOURCE_NOT_FOUND"
        );
    }
}
