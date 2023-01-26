package com.example.sbexeptionhandling.handling.v6;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler {

//    @ExceptionHandler
//    @ResponseStatus(HttpStatus.PAYMENT_REQUIRED)                                             <= we can declare the status here
//    public ResponseEntity<String> handle(PaymentRequiredException exception) {
//        log.error(exception.getMessage(), exception);
//        return new ResponseEntity<>(exception.getMessage(), HttpStatus.PAYMENT_REQUIRED);  <= and we can declare the status here
//    }

    @ExceptionHandler(PaymentRequiredException.class)           // <= for readability we can declare the Exception at the top too
    public ResponseEntity<String> handle(PaymentRequiredException exception) {
        log.error(exception.getMessage(), exception);
        return ResponseEntity
                .status(HttpStatus.PAYMENT_REQUIRED)
                .body(exception.getMessage());
    }
}

/*
    If we want to centralize the exception-handling logic to one class that is capable of handling exceptions 
    thrown from any handler class/ controller class – then we can use @ControllerAdvice annotation.
    
    By default, the methods in an @ControllerAdvice apply globally to all controllers. 
    We can create a class and add @ControllerAdvice annotation on top. 
    Then add @ExceptionHandler methods for each type of specific exception class in it.

 */

/*
    in the console:
    
        com.example.sbexeptionhandling.handling.v6.PaymentRequiredException: Need to pay ...
	        at com.example.sbexeptionhandling.handling.v6.ServiceV6.methodThrowsException(ServiceV6.java:9) ~[main/:na]
	        ...
	
 */