package com.hcl.hackathon.hcl.entity;

import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity(name = "product")
public class ProductEntity extends BaseModel{
    private String productName;
    private BigDecimal productCost;
    private String currency;
    private int ageRestriction;
    private boolean isHarmful;
    
    public String getProductName() {
        return productName;
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    public BigDecimal getProductCost() {
        return productCost;
    }
    
    public void setProductCost(BigDecimal productCost) {
        this.productCost = productCost;
    }
    
    public String getCurrency() {
        return currency;
    }
    
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    
    public int getAgeRestriction() {
        return ageRestriction;
    }
    
    public void setAgeRestriction(int ageRestriction) {
        this.ageRestriction = ageRestriction;
    }
    
    public boolean isHarmful() {
        return isHarmful;
    }
    
    public void setHarmful(boolean harmful) {
        isHarmful = harmful;
    }
}
