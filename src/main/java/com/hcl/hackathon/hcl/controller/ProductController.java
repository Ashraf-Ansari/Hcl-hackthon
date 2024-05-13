package com.hcl.hackathon.hcl.controller;

import com.hcl.hackathon.devlopment.exception.UserNotFoundException;
import com.hcl.hackathon.hcl.entity.ProductEntity;
import com.hcl.hackathon.hcl.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    
    @Autowired ProductService productService;
    
    @GetMapping("/products")
    public ResponseEntity<Object> getUsers(@RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "0") int offset) {
        return productService.findAll(pageSize, offset);
    }
    
    
    @PostMapping("/products")
    public ResponseEntity<Object> createUser(@RequestBody ProductEntity userEntity) {
        return productService.save(userEntity);
    }
    
    @GetMapping("/products/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable("id") Long id) throws UserNotFoundException {
        return productService.findById(id);
    }
}
