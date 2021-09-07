package com.webApp.exceptions;

public class AdminServiceException extends RuntimeException{
    public AdminServiceException(String message){
        super(message);
    }
}
