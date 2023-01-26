package com.example.sbexeptionhandling.handling.v6;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v6/another/pay")
@RequiredArgsConstructor
public class AnotherController {

    private final ServiceV6 service;

    @GetMapping
    public ResponseEntity<String> method() {
        service.methodThrowsException();
        return new ResponseEntity<>(HttpStatus.OK);
    }

   // now we are using ControllerAdvice to handle exception


}

/*

    Request
            GET http://localhost:8080/api/v6/another/pay
            
            
    Response
            HTTP/1.1 402 
            Content-Type: text/plain;charset=UTF-8
            
            Need to pay ...
 */
