package com.example.sbexeptionhandling.handling.v6;

import org.springframework.stereotype.Service;

@Service
public class ServiceV6 {

    public void methodThrowsException() {
        throw new PaymentRequiredException("Need to pay ...");
    }
}
