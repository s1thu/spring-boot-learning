package com.sithu.springrestfundamental.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class PlayerExceptionHandler {

    @ExceptionHandler(PlayerNotFoundException.class)
    public ResponseEntity<PlayerErrorResponse> playerNotFoundHandler(
            Exception exception, HttpServletRequest request
    ){
        PlayerErrorResponse playerErrorResponse = new PlayerErrorResponse(
                ZonedDateTime.now(),HttpStatus.BAD_REQUEST.value(),request.getRequestURI(),exception.getMessage()
        );

        return new ResponseEntity<>(playerErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
