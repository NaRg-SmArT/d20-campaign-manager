package com.mhosler.d20_campaign_manager.controller;

import com.mhosler.d20_campaign_manager.dto.ApiError;
import com.mhosler.d20_campaign_manager.exceptions.RuleNotFoundException;
import com.mhosler.d20_campaign_manager.exceptions.UserNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiError> handleUserNotFound(UserNotFoundException e, HttpServletRequest request) {
        ApiError error = new ApiError(
                HttpStatus.NOT_FOUND,
                e.getMessage(),
                request.getRequestURI(),
                LocalDateTime.now()

        );

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RuleNotFoundException.class)
    public ResponseEntity<ApiError> handleRuleNotFound(RuleNotFoundException e, HttpServletRequest request) {
        ApiError error = new ApiError(
                HttpStatus.NOT_FOUND,
                e.getMessage(),
                request.getRequestURI(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
