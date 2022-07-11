package com.cos.blogv2.errors.exceptions;

import com.cos.blogv2.errors.model.ValidationError;

import java.util.Collection;

public class BadRequestException extends RuntimeException {
    Collection<ValidationError> errors;

    public BadRequestException(Collection<ValidationError> errors) {
        this.errors = errors;
    }
}
