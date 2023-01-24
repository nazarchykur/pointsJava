package com.company.exception_handling;

public class MyBusinessException extends Exception {
    public MyBusinessException() {
    }

    public MyBusinessException(String message) {
        super(message);
    }

    public MyBusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
