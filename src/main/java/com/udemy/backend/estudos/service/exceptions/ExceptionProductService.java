package com.udemy.backend.estudos.service.exceptions;

public class ExceptionProductService extends RuntimeException {

    public ExceptionProductService(String message){
        super(message);
    }
}
