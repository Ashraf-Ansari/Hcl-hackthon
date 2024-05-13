package com.hcl.hackathon.devlopment.controller;

import com.hcl.hackathon.devlopment.exception.ApiResponse;
import com.hcl.hackathon.devlopment.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {
    
    @GetMapping("/test")
    public ResponseEntity<Object> test() {
        ApiResponse exceptionResponse = new ApiResponse(HttpStatus.OK, "Hello World");
        return new ResponseEntity<>(exceptionResponse, HttpStatus.OK);
    }
    
    @GetMapping("/created")
    public ResponseEntity<Object> created() {
        return ResponseEntity.internalServerError().build();
    }
    
    @GetMapping("/exception")
    public String exception() throws UserNotFoundException {
        List<String> numbers = new ArrayList<>();
        numbers.add("1");
        numbers.add("2");
        numbers.add("3");
        if(!numbers.contains("4"))
            throw new UserNotFoundException("User not found");
        return "Hello World from exception";
    }

}
