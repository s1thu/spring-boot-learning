package com.sithu.restchallenge.exception;

public class EbookNotFoundException extends RuntimeException{
    public EbookNotFoundException(String message) {
        super(message);
    }
}
