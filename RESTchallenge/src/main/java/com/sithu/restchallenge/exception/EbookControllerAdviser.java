package com.sithu.restchallenge.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class EbookControllerAdviser {

    @ExceptionHandler
    ResponseEntity<EbookErrorResponse> ebookErrorHandler(
            Exception e, HttpServletRequest request
    ){
        EbookErrorResponse errorResponse = new EbookErrorResponse(
                ZonedDateTime.now(), HttpStatus.BAD_REQUEST.value(), request.getRequestURI(),"Ebook not found"
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
