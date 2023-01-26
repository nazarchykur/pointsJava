package com.example.sbexeptionhandling.handling.v3;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v3/pay")
@RequiredArgsConstructor
public class ControllerV3 {

    private final ServiceV3 service;

    @GetMapping
    public ResponseEntity<String> method() {
        service.methodThrowsException();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

/*

    Without message error in response

            Request
                    GET http://localhost:8080/api/v3/pay
                    
                    
            Response
                    HTTP/1.1 402 
                    Content-Type: application/json
                    
                    {
                      "timestamp": "2023-01-25T15:16:07.827+00:00",
                      "status": 402,
                      "error": "Payment Required",
                      "path": "/api/v3/pay"
                    }

 */


/*
    if we want to add error message to response 
    we need to add to file    application.properties   
    
           server.error.include-message=always
                
                
            Request
                    GET http://localhost:8080/api/v3/pay
                    
                    
            Response
                    HTTP/1.1 402 
                    Content-Type: application/json
                    
                    {
                      "timestamp": "2023-01-25T15:19:37.528+00:00",
                      "status": 402,
                      "error": "Payment Required",
                      "message": "Need to pay ...",                   <= error message
                      "path": "/api/v3/pay"
                    }
 */

/*
    if we want to add exception to response 
    we need to add to file    application.properties   
    
           server.error.include-exception=true
                
                
            Request
                    GET http://localhost:8080/api/v3/pay
                    
                    
            Response
                    HTTP/1.1 402 
                    Content-Type: application/json
                    
                    {
                      "timestamp": "2023-01-25T15:23:37.004+00:00",
                      "status": 402,
                      "error": "Payment Required",
                      "exception": "com.example.sbexeptionhandling.handling.v3.PaymentRequiredException",  <= exception
                      "message": "Need to pay ...",                                                        <= error message
                      "path": "/api/v3/pay"
                    }

 */

/*
    if we want to add stacktrace to response 
    we need to add to file    application.properties   
    
           server.error.include-stacktrace=always
       
 */