package com.ortiz.web.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {IllegalArgumentException.class})
    protected ResponseEntity<Object> handleValidationError(IllegalArgumentException ex, WebRequest request) {
        return handleExceptionInternal(ex, "", new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
