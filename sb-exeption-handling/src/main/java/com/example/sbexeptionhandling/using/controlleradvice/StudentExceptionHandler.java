package com.example.sbexeptionhandling.using.controlleradvice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentExceptionHandler {

    @ExceptionHandler
    public String handleInvalidFieldException(InvalidFieldException e) {
        return e.getMessage();
    }

    @ExceptionHandler
    public ResponseEntity<?> handleInvalidFieldException(InvalidEntityException e) {
        return ResponseEntity
                .badRequest()
                .body(e.getMessage());
    }
}
