package com.adaps.water.exception;

public class BadRequestExceptionHandler extends RuntimeException {
    public BadRequestExceptionHandler(String message) {
        super(message);
    }
}
