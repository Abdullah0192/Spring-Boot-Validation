/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dto;
import java.util.Map;
public class ValidationErrorResponse {
    private int status;
    private String message;
    private Map<String, String> errors;
    public ValidationErrorResponse(){
        
    }
    public ValidationErrorResponse(int status, String message, Map<String, String> errors){
        this.status = status;
        this.message = message;
        this.errors = errors;
    }
    public int getStatus(){
        return status;
    }
    public void setStatus(int status){
        this.status = status;
    }
    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message = message;
    }
    public Map<String, String> getErrors(){
        return errors;
    }
    public void setErrors(Map<String, String> errors){
        this.errors = errors;
    }
}
