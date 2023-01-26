package com.example.sbexeptionhandling.using.controlleradvice;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class InvalidFieldException extends RuntimeException {
    private String message;

}
