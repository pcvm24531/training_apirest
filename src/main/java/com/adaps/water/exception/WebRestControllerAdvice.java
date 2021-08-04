package com.adaps.water.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class WebRestControllerAdvice extends Throwable {

    private static final Logger log = LoggerFactory.getLogger(WebRestControllerAdvice.class);

    @ExceptionHandler(NotFoundExceptionHandler.class)
    public ResponseEntity<?> notFoundExceptionHandler(Exception e){
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestExceptionHandler.class)
    public ResponseEntity<?> badRequestException(Exception e){
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    /*
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(@org.jetbrains.annotations.NotNull NotFoundException e) {
        String message = e.getMessage();
        return new ResponseEntity<String>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception e) {
        String idMessage = UUID.randomUUID().toString();
        log.error(e.getMessage() + " " + idMessage, e);

        String message = "Please contact administration ID: " + idMessage;
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    */

}
