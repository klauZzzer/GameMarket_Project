package org.example.gamemarket.controller;

import org.example.gamemarket.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DeveloperAlreadyExistException.class)
    public ResponseEntity<ErrorExtension> handleDeveloperAlreadyExistException(Exception e) {
        return new ResponseEntity<>(new ErrorExtension(
                e.getMessage(), HttpStatus.CONFLICT),
                HttpStatus.CONFLICT
        );
    }

    @ExceptionHandler(DeveloperDoesNotExistException.class)
    public ResponseEntity<ErrorExtension> handleDeveloperDoesNotExistException(Exception e) {
        return new ResponseEntity<>(new ErrorExtension(
                e.getMessage(), HttpStatus.NOT_FOUND),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(GameAlreadyExistException.class)
    public ResponseEntity<ErrorExtension> handleGameAlreadyExistException(Exception e) {
        return new ResponseEntity<>(new ErrorExtension(
                e.getMessage(), HttpStatus.CONFLICT),
                HttpStatus.CONFLICT
        );
    }

    @ExceptionHandler(GameDoesNotExistException.class)
    public ResponseEntity<ErrorExtension> handleGameDoesNotExistException(Exception e) {
        return new ResponseEntity<>(new ErrorExtension(
                e.getMessage(), HttpStatus.NOT_FOUND),
                HttpStatus.NOT_FOUND
        );
    }







}
