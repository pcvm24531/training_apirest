package com.adaps.water.exception;

import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.UUID;

@RestControllerAdvice
public class WebRestControllerAdvice extends Throwable {

    private static final Logger log = LoggerFactory.getLogger(WebRestControllerAdvice.class);

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(@org.jetbrains.annotations.NotNull NotFoundException e) {
        String message = e.getMessage();
        return new ResponseEntity<String>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception e) {
        String idMessage = UUID.randomUUID().toString();
        log.error(e.getMessage() + " " + idMessage, e);

        String message = "pPlease contact administration ID: " + idMessage;
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EmptyFieldException.class)
    public ResponseEntity<String> emptyFieldExceptionHandler(EmptyFieldException e) {
        String message = e.getMessage();
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
}
