package com.example.sbexeptionhandling.handling.v7;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v7/pay")
@RequiredArgsConstructor
public class ControllerV7 {

    private final ServiceV7 service;

    @GetMapping
    public ResponseEntity<String> method() {
        service.methodThrowsException();
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}

/*

    Request
            GET http://localhost:8080/api/v7/pay
            
            
    Response
            HTTP/1.1 402 
            Content-Type: application/json
            
            {
              "status": "PAYMENT_REQUIRED",
              "message": "Need to pay ...",
              "time": "2023-01-25 18:24:49"
            }
 */