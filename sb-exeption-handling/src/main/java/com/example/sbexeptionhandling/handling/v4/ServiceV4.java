package com.example.sbexeptionhandling.handling.v4;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ServiceV4 {

    public void methodThrowsException() {
        try {
            methodWithPaymentRequired();
        } catch (PaymentRequiredException e) {
            throw new ResponseStatusException(HttpStatus.PAYMENT_REQUIRED, "Need to pay");
        }
    }

    public void methodWithPaymentRequired() {
        throw new PaymentRequiredException("Need to pay ...");
    }
}
