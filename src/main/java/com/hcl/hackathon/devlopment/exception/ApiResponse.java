package com.hcl.hackathon.devlopment.exception;

import org.springframework.http.HttpStatus;

public class ApiResponse {
    
        private int status;
        private String message;
        private Object data;
        
        public ApiResponse() {
            super();
        }
        
        public ApiResponse(HttpStatus status, String message, Object data) {
            super();
            this.status = status.value();
            this.message = message;
            this.data = data;
        }
        
        public ApiResponse(Integer status, String message, Object data) {
            super();
            this.status = status;
            this.message = message;
            this.data = data;
        }
        
        public ApiResponse(HttpStatus status, String message) {
            super();
            this.status = status.value();
            this.message = message;
            
        }
    
        public ApiResponse(HttpStatus status, Object data) {
            super();
            this.status = status.value();
            this.data = data;
        }
        
        public int getStatus() {
            return status;
        }
        
        public void setStatus(int status) {
            this.status = status;
        }
        
        public String getMessage() {
            return message;
        }
        
        public void setMessage(String message) {
            this.message = message;
        }
        
        public Object getData() {
            return data;
        }
        
        public void setData(Object data) {
            this.data = data;
        }
        
        @Override
        public String toString() {
            return "ApiResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
        }
}
