package com.ortiz.exception;

import com.ortiz.poc.dto.ErrorDTO;
import io.grpc.StatusRuntimeException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {IllegalArgumentException.class, IllegalStateException.class})
    protected ResponseEntity<Object> handleValidationError(Exception ex, WebRequest request) {
        return handleError(ex, request, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<Object> handleGenericError(Exception ex, WebRequest request) {
        return handleError(ex, request, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {EntityNotFoundException.class})
    protected ResponseEntity<Object> handleEntityNotFound(Exception ex, WebRequest request) {
        return handleError(ex, request, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {StatusRuntimeException.class})
    protected ResponseEntity<Object> handleGrpcException(StatusRuntimeException ex, WebRequest request) {
        HttpStatus status;
        switch (ex.getStatus().getCode()) {
            case NOT_FOUND:
                status = HttpStatus.NOT_FOUND;
                break;
            default:
                status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return handleError(ex, request, status);
    }

    private ResponseEntity<Object> handleError(Exception ex, WebRequest request, HttpStatus status) {
        ErrorDTO errorDTO = ErrorDTO.builder().message(ex.getMessage()).cause(ex).build();
        return handleExceptionInternal(ex, errorDTO, new HttpHeaders(), status, request);
    }
}
