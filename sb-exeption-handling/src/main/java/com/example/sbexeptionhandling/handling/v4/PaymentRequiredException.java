package com.example.sbexeptionhandling.handling.v4;


public class PaymentRequiredException extends RuntimeException {

    public PaymentRequiredException( String reason) {
        super(reason);
    }
}
