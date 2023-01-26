package com.example.sbexeptionhandling.handling.v7;

import org.springframework.stereotype.Service;

@Service
public class ServiceV7 {

    public void methodThrowsException() {
        throw new PaymentRequiredException("Need to pay ...");
    }
}
