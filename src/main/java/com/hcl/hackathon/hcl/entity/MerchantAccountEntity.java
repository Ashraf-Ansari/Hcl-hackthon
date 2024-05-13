package com.hcl.hackathon.hcl.entity;

import jakarta.persistence.Entity;

import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "merchant_account")
public class MerchantAccountEntity extends BaseModel {
    private String merchantName;
    private String merchantType;
    private String accountNumber;
    private BigDecimal balance;
    private String currency;
    private Date lastUpdated;
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    public BigDecimal getBalance() {
        return balance;
    }
    
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    
    public String getCurrency() {
        return currency;
    }
    
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    
    public Date getLastUpdated() {
        return lastUpdated;
    }
    
    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
    
    public String getMerchantType() {
        return merchantType;
    }
    
    public void setMerchantType(String merchantType) {
        this.merchantType = merchantType;
    }
    
    public String getMerchantName() {
        return merchantName;
    }
    
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }
}
