package com.hcl.hackathon.devlopment;

import jakarta.validation.constraints.Size;

public class User {
    
    @Size(min = 2, message = "Name should have atleast 2 characters")
    String name;
    
    String email;
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
