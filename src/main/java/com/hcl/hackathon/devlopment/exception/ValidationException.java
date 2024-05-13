package com.hcl.hackathon.devlopment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ValidationException extends Exception{
    public HttpStatus getStatusCode() {
        return HttpStatus.BAD_REQUEST;
    }
    
    public ValidationException(String message) {
        super(message);
    }
}
