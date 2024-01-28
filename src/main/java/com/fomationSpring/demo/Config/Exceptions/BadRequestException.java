package com.fomationSpring.demo.Config.Exceptions;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message ){
        super(message);

    }
}
