package com.sac.rest.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sac.exception.RecrtError;

/**
 * The error transfer object used to provide error info when exception is thrown
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResource extends RecrtError {

    private List<FieldErrorResource> fieldErrors;

    public ErrorResource() {
        super(422, "Validation error.");
    }

    public ErrorResource(String message) {
        super(422, message);
    }

    public ErrorResource(int code, String message) {
        super(code, message);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<FieldErrorResource> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(List<FieldErrorResource> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }
}

