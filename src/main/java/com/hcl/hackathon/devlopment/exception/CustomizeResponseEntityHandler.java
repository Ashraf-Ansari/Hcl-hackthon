package com.hcl.hackathon.devlopment.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CustomizeResponseEntityHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
        ApiResponse exceptionResponse = new ApiResponse(ex.getStatusCode(), ex.getMessage());
        return new ResponseEntity<>(exceptionResponse, ex.getStatusCode());
    }
    @ExceptionHandler(ValidationException.class)
    public final ResponseEntity<Object> validationException(ValidationException ex, WebRequest request) {
        ApiResponse exceptionResponse = new ApiResponse(ex.getStatusCode(), ex.getMessage());
        return new ResponseEntity<>(exceptionResponse, ex.getStatusCode());
    }
    
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        ApiResponse exceptionResponse = new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
        MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ApiResponse exceptionResponse = new ApiResponse(HttpStatus.BAD_REQUEST, ex.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
    
}
