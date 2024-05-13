package com.hcl.hackathon.hcl.entity;

import jakarta.persistence.Entity;

import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "wallet")
public class WalletEntity extends BaseModel{
    
    private Integer userId;
    private BigDecimal balance;
    private Date lastUpdated;
    
    public Date getLastUpdated() {
        return lastUpdated;
    }
    
    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
    
    public BigDecimal getBalance() {
        return balance;
    }
    
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    
    public Integer getUserId() {
        return userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
