package com.ortiz.exception;

import com.ortiz.dto.ErrorDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice()
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {IllegalArgumentException.class, IllegalStateException.class})
    protected ResponseEntity<Object> handleValidationError(Exception ex, WebRequest request) {
        return handleError(ex, request, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<Object> handleGenericError(Exception ex, WebRequest request) {
        return handleError(ex, request, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<Object> handleError(Exception ex, WebRequest request, HttpStatus status) {
        ErrorDTO errorDTO = ErrorDTO.builder().message(ex.getMessage()).cause(ex).build();
        return handleExceptionInternal(ex, errorDTO, new HttpHeaders(), status, request);
    }
}
