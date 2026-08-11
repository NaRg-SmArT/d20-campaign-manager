package com.mhosler.d20_campaign_manager.dto;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

public class InputValidationError {
    private HttpStatus status;
    private List<String> errors;
    private String path;
    private LocalDateTime timestamp;

    public InputValidationError() {

    }
    public InputValidationError(HttpStatus status, List<String> errors,  String path, LocalDateTime timestamp) {
        this.status = status;
        this.errors = errors;
        this.path = path;
        this.timestamp = timestamp;
    }

    public HttpStatus getStatus() {
        return status;
    }
    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public List<String> getErrors() {
        return errors;
    }
    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
