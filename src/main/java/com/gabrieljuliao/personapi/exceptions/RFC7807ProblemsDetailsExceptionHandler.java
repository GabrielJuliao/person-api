package com.gabrieljuliao.personapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RFC7807ProblemsDetailsExceptionHandler {
    @ExceptionHandler(value = com.gabrieljuliao.personapi.exceptions.ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundHandler(com.gabrieljuliao.personapi.exceptions.ResourceNotFoundException e) {
        HttpStatus notFound = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(
                new com.gabrieljuliao.personapi.exceptions.RFC7807ProblemsDetails("Resource not found", notFound.value(), "Requested resource does not exist"),
                notFound
        );
    }
}
