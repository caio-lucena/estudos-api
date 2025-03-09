package com.udemy.backend.estudos.handler;

import com.udemy.backend.estudos.model.errors.ErrorMessage;
import com.udemy.backend.estudos.model.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHendler {

    //TODO pensar em outros status (bad request, internal server error...)

    @ExceptionHandler
    public ResponseEntity<?> handlerResourceNotFoundException(ResourceNotFoundException resourceNotFoundEx){
        ErrorMessage error = new ErrorMessage("Not Found", HttpStatus.NOT_FOUND.value(), resourceNotFoundEx.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }

}
