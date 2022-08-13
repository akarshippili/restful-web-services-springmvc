package com.akarsh.restwebservices.exception;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class ErrorDetails {

    private Date timestamp;
    private String message;
    private String path;
    private HttpStatus status;


    public ErrorDetails(String message, String path, HttpStatus status){
        this.timestamp = new Date();
        this.message = message;
        this.path = path;
        this.status = status;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
