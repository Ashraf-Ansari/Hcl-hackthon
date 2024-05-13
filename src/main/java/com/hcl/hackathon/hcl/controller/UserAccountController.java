package com.hcl.hackathon.hcl.controller;

import com.hcl.hackathon.devlopment.exception.UserNotFoundException;
import com.hcl.hackathon.hcl.entity.UserAccountEntity;
import com.hcl.hackathon.hcl.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAccountController {
    
    @Autowired UserAccountService userAccountService;
    
    @GetMapping("/usersAccounts")
    public ResponseEntity<Object> getUsers(@RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "0") int offset) {
        return userAccountService.findAll(pageSize, offset);
    }
    
    
    @PostMapping("/usersAccounts")
    public ResponseEntity<Object> createUser(@RequestBody UserAccountEntity userEntity) {
        return userAccountService.save(userEntity);
    }
    
    @GetMapping("/usersAccounts/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable("id") Long id) throws UserNotFoundException {
        return userAccountService.findById(id);
    }
}
