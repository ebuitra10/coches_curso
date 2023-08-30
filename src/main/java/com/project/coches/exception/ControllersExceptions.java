package com.project.coches.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.Map;

//La anotacion es la que va a lanzar la excepcion
@RestControllerAdvice
public class ControllersExceptions {

    //los maps son estructuras que manejan clave : valor al igual que los Json
    @ExceptionHandler({CustomerNotExistException.class, PasswordIncorrectException.class, EmailValidationException.class})
    public ProblemDetail customerNotExist(RuntimeException runtimeException){
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, runtimeException.getMessage());
    }
}
