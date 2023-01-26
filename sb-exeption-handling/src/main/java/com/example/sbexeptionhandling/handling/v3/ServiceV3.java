package com.example.sbexeptionhandling.handling.v3;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ServiceV3 {

    public void methodThrowsException() {
        throw new PaymentRequiredException(HttpStatus.PAYMENT_REQUIRED, "Need to pay ...");
    }
}
