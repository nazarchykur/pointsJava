package com.example.sbexeptionhandling.handling.v7;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class CustomExceptionHandlerV7 {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.PAYMENT_REQUIRED)
    public ResponseError handle(PaymentRequiredException exception) {
        log.error(exception.getMessage(), exception);
        return new ResponseError(exception.getMessage(), HttpStatus.PAYMENT_REQUIRED);
    }
}

/*
    If we want to centralize the exception-handling logic to one class that is capable of handling exceptions 
    thrown from any handler class/ controller class – then we can use @ControllerAdvice annotation.
    
    By default, the methods in an @ControllerAdvice apply globally to all controllers. 
    We can create a class and add @ControllerAdvice annotation on top. 
    Then add @ExceptionHandler methods for each type of specific exception class in it.

 */