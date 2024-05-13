package com.hcl.hackathon.hcl.controller;

import com.hcl.hackathon.hcl.entity.UserEntity;
import com.hcl.hackathon.devlopment.exception.UserNotFoundException;
import com.hcl.hackathon.hcl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    @Autowired UserService userService;

    @GetMapping("/users")
    public ResponseEntity<Object> getUsers(@RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "0") int offset) {
        return userService.findAll(pageSize, offset);
    }


    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody UserEntity userEntity) {
        return userService.save(userEntity);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable("id") Long id) throws UserNotFoundException {
        return userService.findById(id);
    }
    
}
