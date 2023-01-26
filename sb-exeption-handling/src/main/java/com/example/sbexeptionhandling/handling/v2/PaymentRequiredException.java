package com.example.sbexeptionhandling.handling.v2;


public class PaymentRequiredException extends RuntimeException {

    public PaymentRequiredException( String reason) {
        super(reason);
    }
}
