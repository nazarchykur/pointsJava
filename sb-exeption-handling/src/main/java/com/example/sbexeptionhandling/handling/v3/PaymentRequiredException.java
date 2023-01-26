package com.example.sbexeptionhandling.handling.v3;


import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class PaymentRequiredException extends ResponseStatusException {

    public PaymentRequiredException(HttpStatusCode status, String reason) {
        super(status, reason);
    }
}
