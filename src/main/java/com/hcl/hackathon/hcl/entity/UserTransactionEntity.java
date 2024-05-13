package com.hcl.hackathon.hcl.entity;

import jakarta.persistence.Entity;

import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "user_transaction")
public class UserTransactionEntity extends BaseModel{
    private String transactionID;
    private Integer userID;
    private Integer productID;
    private BigDecimal amount;
    private String currency;
    private String status;
    private Date timestamp;
    private String transactionType;
    private String transactionDescription;
    
    public String getTransactionID() {
        return transactionID;
    }
    
    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }
    
    public Integer getUserID() {
        return userID;
    }
    
    public void setUserID(Integer userID) {
        this.userID = userID;
    }
    
    public Integer getProductID() {
        return productID;
    }
    
    public void setProductID(Integer productID) {
        this.productID = productID;
    }
    
    public BigDecimal getAmount() {
        return amount;
    }
    
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    
    public String getCurrency() {
        return currency;
    }
    
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public Date getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    
    public String getTransactionType() {
        return transactionType;
    }
    
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
    
    public String getTransactionDescription() {
        return transactionDescription;
    }
    
    public void setTransactionDescription(String transactionDescription) {
        this.transactionDescription = transactionDescription;
    }
}
