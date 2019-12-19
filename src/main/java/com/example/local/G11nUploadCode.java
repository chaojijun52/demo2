package com.example.local;

public enum G11nUploadCode {
    
OK(200, "OK", "api_upload_response_ok"),    
ERROR(400, "WRONG REQUEST", "api_upload_response_wrong_request"),
CREATED(201, "CREATED", "api_upload_response_create"),
UNAUTHORIZED(401, "UNAUTHORIZED", "api_upload_response_unauthorized"),
FORBIDDEN(403, "FORBIDDEN", "api_upload_response_forbidden"),
NOT_FOUND(404, "NOT FOUND", "api_upload_response_not_found");
     
    private int code;
    private String status;
    private String propertyKey;
 
    private G11nUploadCode(int code, String status, String propertyKey) {
        this.code = code;
        this.status= status;
        this.propertyKey = propertyKey;
    }
 
    public void seCode(int code) {
        this.code = code;
    }
     
    public int getCode() {
        return this.code;
    }
 
    public String getStatus() {
        return this.status;
    }
     
    public void seStatus(String status) {
        this.status = status;
    }
 
    public void setPropertyKey(String propertyKey) {
        this.propertyKey = propertyKey;
    }
     
    public String getPropertyKey() {
        return this.propertyKey;
    }
}
