package com.hcl.hackathon.hcl.entity;

import jakarta.persistence.Entity;

import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "currency")
public class CurrencyEntity extends BaseModel {
    
    private String currencyCode;
    private String currencyName;
    private String symbol;
    private BigDecimal exchangeRateToBase;
    private Date lastUpdated;
    
    public String getCurrencyCode() {
        return currencyCode;
    }
    
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
    
    public String getCurrencyName() {
        return currencyName;
    }
    
    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }
    
    public String getSymbol() {
        return symbol;
    }
    
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    
    public BigDecimal getExchangeRateToBase() {
        return exchangeRateToBase;
    }
    
    public void setExchangeRateToBase(BigDecimal exchangeRateToBase) {
        this.exchangeRateToBase = exchangeRateToBase;
    }
    
    public Date getLastUpdated() {
        return lastUpdated;
    }
    
    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
