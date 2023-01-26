package com.example.sbexeptionhandling.handling.v2;

import org.springframework.stereotype.Service;

@Service
public class ServiceV2 {

    public void methodThrowsException() {
        throw new PaymentRequiredException("Need to pay ...");
    }
}
