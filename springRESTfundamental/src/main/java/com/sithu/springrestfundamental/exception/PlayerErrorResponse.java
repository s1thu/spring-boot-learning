package com.sithu.springrestfundamental.exception;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.ZonedDateTime;

public class PlayerErrorResponse {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private ZonedDateTime zonedDateTime;
    private int statusCode;
    private String path;
    private String message;

    public PlayerErrorResponse() {
    }

    public PlayerErrorResponse(ZonedDateTime zonedDateTime, int statusCode, String path, String message) {
        this.zonedDateTime = zonedDateTime;
        this.statusCode = statusCode;
        this.path = path;
        this.message = message;
    }

    public ZonedDateTime getZonedDateTime() {
        return zonedDateTime;
    }

    public void setZonedDateTime(ZonedDateTime zonedDateTime) {
        this.zonedDateTime = zonedDateTime;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
