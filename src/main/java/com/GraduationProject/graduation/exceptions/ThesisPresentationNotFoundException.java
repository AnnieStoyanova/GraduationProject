package com.GraduationProject.graduation.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ThesisPresentationNotFoundException extends RuntimeException {
    public ThesisPresentationNotFoundException(String message) {
        super(message);
    }
}

