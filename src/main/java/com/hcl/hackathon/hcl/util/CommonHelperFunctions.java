package com.hcl.hackathon.hcl.util;

import java.math.BigDecimal;
import java.util.UUID;

public class CommonHelperFunctions {
    
    public CommonHelperFunctions() {
        throw new UnsupportedOperationException();
    }
    
    public static String getStringValue(Object s) {
        return s != null ? s.toString() : "";
    }
    
    public static String getStringValueOrEmptyArrayString(Object s) {
        return s != null ? s.toString() : "[]";
    }
    
    public static String getStringValueOrEmptyMapString(Object s) {
        return s != null ? s.toString() : "{}";
    }
    
    public static String getStringValueOrDefault(Object s, String defaultString) {
        return s != null ? s.toString() : defaultString;
    }
    
    public static Long getLongValue(Object s) {
        try {
            return s != null ? (long) Double.parseDouble(s.toString()) : Long.parseLong("0");
        } catch (NumberFormatException e) {
            return Long.parseLong("0");
        }
    }
    
    public static Integer getIntegerValue(Object s) {
        try {
            return s != null ? (int) Double.parseDouble(s.toString()) : 0;
        } catch (NumberFormatException e) {
            return 0;
        }
    }
    
    public static Double getDoubleValue(Object s) {
        try {
            return s != null ? Double.parseDouble(s.toString()) : Double.parseDouble("0");
        } catch (NumberFormatException e) {
            return Double.parseDouble("0");
        }
    }
    
    public static BigDecimal getBigDecimalValue(Object s) {
        try {
            return s != null ? new BigDecimal(s.toString()) : new BigDecimal("0");
        } catch (NumberFormatException e) {
            return new BigDecimal("0");
        }
    }
    
    public static String getTransactionUUID() {
        return UUID.randomUUID().toString();
    }
    
}
