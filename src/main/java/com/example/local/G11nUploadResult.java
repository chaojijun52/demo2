package com.example.local;

import java.io.IOException;
import java.io.Serializable;

public class G11nUploadResult implements Serializable {
	 
private static final long serialVersionUID = 1L;    
private int code;
private String status;
private Object data;
     
public void setCode(int code) {
        this.code = code;
    }
         
public int getCode() {
    return this.code;
}
 
public void setStatus(String status) {
    this.status = status;
}
     
public String getStatus() {
    return this.status;
}
     
public void setData(Object data) {
    this.data = data;
}
     
public Object getData() {
    return this.data;
}
     
public G11nUploadResult() {}
     
public G11nUploadResult(int code, String status, Object data) {     
this.code = code;
    this.status = status;       
this.data = data;
}
     
public G11nUploadResult(G11nUploadCode responseCodeI18n, String language) throws IOException{
    CustomizeMessageResource customizeMessageResource = new CustomizeMessageResource();
         
    this.code = responseCodeI18n.getCode();
    this.status = responseCodeI18n.getStatus();
    System.out.println("Status: " + this.status);
    this.data = customizeMessageResource.getMessage(responseCodeI18n.getPropertyKey(), language);
 }  
}
