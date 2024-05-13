package com.hcl.hackathon.hcl.controller;

import com.hcl.hackathon.devlopment.exception.UserNotFoundException;
import com.hcl.hackathon.devlopment.exception.ValidationException;
import com.hcl.hackathon.hcl.pojo.PurchaseRequest;
import com.hcl.hackathon.hcl.service.PaymentInitiateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PurchaseInitiationController {
    
    @Autowired PaymentInitiateService paymentInitiateService;
    
    @PostMapping("/initiate-flow")
    public ResponseEntity<Object> createUser(@RequestBody PurchaseRequest purchaseRequest)
        throws UserNotFoundException, ValidationException {
        paymentInitiateService.purchaseInitiationService(purchaseRequest);
        return ResponseEntity.ok().build();
    }
}
