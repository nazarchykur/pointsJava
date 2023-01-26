package com.example.sbexeptionhandling.handling.v1;

import org.springframework.stereotype.Service;

@Service
public class ServiceV1 {

    public void methodThrowsException() {
        throw new PaymentRequiredException("Need to pay ...");
    }
}
