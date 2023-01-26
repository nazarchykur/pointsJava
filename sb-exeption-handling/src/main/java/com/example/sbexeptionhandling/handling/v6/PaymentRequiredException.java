package com.example.sbexeptionhandling.handling.v6;


public class PaymentRequiredException extends RuntimeException {

    public PaymentRequiredException( String reason) {
        super(reason);
    }
}
