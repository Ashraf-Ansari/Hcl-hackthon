package com.hcl.hackathon.hcl.controller;

import com.hcl.hackathon.devlopment.exception.UserNotFoundException;
import com.hcl.hackathon.hcl.entity.ProductEntity;
import com.hcl.hackathon.hcl.entity.WalletEntity;
import com.hcl.hackathon.hcl.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletController {

    @Autowired WalletService walletService;
    
    @GetMapping("/wallet")
    public ResponseEntity<Object> getUsers(@RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "0") int offset) {
        return walletService.findAll(pageSize, offset);
    }
    
    
    @PostMapping("/wallet")
    public ResponseEntity<Object> createUser(@RequestBody WalletEntity userEntity) {
        return walletService.save(userEntity);
    }
    
    @GetMapping("/wallet/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable("id") Long id) throws UserNotFoundException {
        return walletService.findById(id);
    }
}
