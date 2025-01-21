package com.sithu.databaserelationship.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(PlayerNotFoundException.class)
    public ResponseEntity<ExceptionResponse> playerNotFoundHandler(PlayerNotFoundException exception, HttpServletRequest request){
        ExceptionResponse errorResponse = new ExceptionResponse(
                    exception.getMessage(), ZonedDateTime.now(),HttpStatus.NOT_FOUND.value(), request.getRequestURI()

        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleGlobalException(Exception exception, HttpServletRequest request){
        ExceptionResponse errorResponse = new ExceptionResponse(
                exception.getMessage(), ZonedDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(), request.getRequestURI()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
