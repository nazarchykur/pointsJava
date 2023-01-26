package com.example.sbexeptionhandling.handling.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pay")
@RequiredArgsConstructor
public class ControllerV1 {
    
    private final ServiceV1 service; 
    
    @GetMapping
    public void method() {
        service.methodThrowsException();
    }
}

/*
    Request
            GET http://localhost:8080/api/v1/pay
            
            
    Response
            HTTP/1.1 500 
            Content-Type: application/json
            
            {
              "timestamp": "2023-01-25T15:00:37.782+00:00",
              "status": 500,
              "error": "Internal Server Error",
              "path": "/api/v1/pay"
            }      
 */