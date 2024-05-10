package com.hcl.hackathon.devlopment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends Exception{

//    ResponseEntityExceptionHandler class handle all exceptions
    
    public HttpStatus getStatusCode() {
        return HttpStatus.NOT_FOUND;
    }
    
    public UserNotFoundException(String message) {
        super(message);
    }
}
