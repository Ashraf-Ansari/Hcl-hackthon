package com.hcl.hackathon.devlopment.controller;

import com.hcl.hackathon.devlopment.User;
import com.hcl.hackathon.devlopment.exception.ApiResponse;
import com.hcl.hackathon.devlopment.exception.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class TestController {
    
    @GetMapping("/test")
    public ResponseEntity<Object> test(@Valid @RequestBody User user) {
        ApiResponse exceptionResponse = new ApiResponse(200, "Hello World", user);
        return new ResponseEntity(exceptionResponse, HttpStatus.OK);
    }
    
    @GetMapping("/created")
    public ResponseEntity<Object> created() {
        //        return "Hello World";
        return ResponseEntity.internalServerError().build();
    }
    
    @GetMapping("/exception")
    public String exception() throws UserNotFoundException {
        List<String> numbers = new ArrayList<>();
        numbers.add("1");
        numbers.add("2");
        numbers.add("3");
//        numbers.add("4");
        if(!numbers.contains("4"))
            throw new UserNotFoundException("User not found");
        return "Hello World from exception";
    }

}
