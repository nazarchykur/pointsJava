package com.example.sbexeptionhandling.handling.v5;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v5/pay")
@RequiredArgsConstructor
public class ControllerV5 {

    private final ServiceV5 service;

    @GetMapping
    public ResponseEntity<String> method() {
        service.methodThrowsException();
//        return ResponseEntity.ok().body("");
//        return ResponseEntity.ok("");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*
        
        This approach has a major drawback: The @ExceptionHandler annotated method is only active for that 
        particular Controller, not globally for the entire application. 
        
        Of course, adding this to every controller makes it not well suited for a general exception handling mechanism.
        
     */

//    @ExceptionHandler({PaymentRequiredException.class, NullPointerException.class})  // Handling Multiple Exceptions
//    @ExceptionHandler(PaymentRequiredException.class)                                                    <= example 1
//    public ResponseEntity<String> handleException() {
//        return new ResponseEntity<>(HttpStatus.PAYMENT_REQUIRED);
//    }


    //  if we want to have access to Exception, we need to use it as parameter                             <= example 2

    @ExceptionHandler
    public ResponseEntity<String> handleException(PaymentRequiredException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.PAYMENT_REQUIRED);
    }
}

/*
example 1

    Request
            GET http://localhost:8080/api/v5/pay
            
            
    Response
            HTTP/1.1 402 
            Content-Type: text/plain;charset=UTF-8
            
                                                                <= There is no message in the body for the response
 */

/*

example 2

    Request
            GET http://localhost:8080/api/v5/pay
            
            
    Response
            HTTP/1.1 402 
            Content-Type: text/plain;charset=UTF-8
            
            Need to pay ...                                     <= There is a body
 */ 