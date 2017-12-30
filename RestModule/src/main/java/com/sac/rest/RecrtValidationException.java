package com.sac.rest;

import org.springframework.validation.Errors;

import com.sac.rest.model.ErrorResource;

/**
 * Used to throw form validation exceptions
 */
public class RecrtValidationException extends RuntimeException {

    private Errors errors;

    private ErrorResource errorResource;

    public RecrtValidationException(String message, Errors errors) {
        super(message);
        this.errors = errors;
    }

    public RecrtValidationException(ErrorResource errorResource) {
        super(errorResource.getMessage());
        this.errorResource = errorResource;
    }

    public Errors getErrors() {
        return errors;
    }

    public ErrorResource getErrorResource() {
        return errorResource;
    }
}
