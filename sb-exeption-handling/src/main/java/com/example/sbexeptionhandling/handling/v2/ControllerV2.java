package com.example.sbexeptionhandling.handling.v2;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/pay")
@RequiredArgsConstructor
public class ControllerV2 {
    
    private final ServiceV2 service; 
    
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
            GET http://localhost:8080/api/v2/pay
            
            
    Response
            HTTP/1.1 402 
            Content-Type: text/plain;charset=UTF-8
            
            Need to pay...

 */