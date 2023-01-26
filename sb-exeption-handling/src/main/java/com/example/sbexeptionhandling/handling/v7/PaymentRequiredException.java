package com.example.sbexeptionhandling.handling.v7;


public class PaymentRequiredException extends RuntimeException {

    public PaymentRequiredException( String reason) {
        super(reason);
    }
}
