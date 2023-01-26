package com.example.sbexeptionhandling.using.controlleradvice;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class InvalidEntityException extends RuntimeException {
    private String message;

}
