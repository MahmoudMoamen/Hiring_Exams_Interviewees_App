package com.webApp.exceptions;

public class QuestionServiceException extends RuntimeException{
    public QuestionServiceException(String message){
        super(message);
    }
}
