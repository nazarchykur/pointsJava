package com.example.sbexeptionhandling.handling.v5;

import org.springframework.stereotype.Service;

@Service
public class ServiceV5 {

    public void methodThrowsException() {
        throw new PaymentRequiredException("Need to pay ...");
    }
}
