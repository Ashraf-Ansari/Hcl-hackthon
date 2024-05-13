package com.hcl.hackathon.hcl.controller;

import com.hcl.hackathon.devlopment.exception.UserNotFoundException;
import com.hcl.hackathon.hcl.entity.MerchantAccountEntity;
import com.hcl.hackathon.hcl.service.MerchantAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MerchentAccountController {
    
    @Autowired MerchantAccountService merchantAccountService;
    
    @GetMapping("/merchents")
    public ResponseEntity<Object> getUsers(@RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "0") int offset) {
        return merchantAccountService.findAll(pageSize, offset);
    }
    
    
    @PostMapping("/merchents")
    public ResponseEntity<Object> createUser(@RequestBody MerchantAccountEntity userEntity) {
        return merchantAccountService.save(userEntity);
    }
    
    @GetMapping("/merchents/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable("id") Long id) throws UserNotFoundException {
        return merchantAccountService.findById(id);
    }
}
