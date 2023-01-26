package com.example.sbexeptionhandling.handling.v4;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v4/pay")
@RequiredArgsConstructor
public class ControllerV4 {
    
    private final ServiceV4 service; 
    
    @GetMapping
    public ResponseEntity<String> method() {
        try {
            service.methodThrowsException();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (PaymentRequiredException e) {
            return new ResponseEntity<>("Need to pay...", HttpStatus.PAYMENT_REQUIRED);
        }
    }
}

/*
    Request
            GET http://localhost:8080/api/v4/pay
            
            
    Response
            HTTP/1.1 402 
            Content-Type: application/json
            
            {
              "timestamp": "2023-01-25T15:36:34.275+00:00",
              "status": 402,
              "error": "Payment Required",
              "message": "Need to pay",
              "path": "/api/v4/pay"
            }

 */