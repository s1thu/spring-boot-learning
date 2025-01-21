package com.sithu.databaserelationship.exception;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.ZonedDateTime;

public class ExceptionResponse {

    private String message;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private ZonedDateTime timeStamp;
    private int statusCode;
    private String path;

    public ExceptionResponse(String message, ZonedDateTime timeStamp, int statusCode, String path) {
        this.message = message;
        this.timeStamp = timeStamp;
        this.statusCode = statusCode;
        this.path = path;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ZonedDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(ZonedDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
