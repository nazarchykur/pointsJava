package com.example.sbexeptionhandling.handling.v5;


public class PaymentRequiredException extends RuntimeException {

    public PaymentRequiredException( String reason) {
        super(reason);
    }
}
