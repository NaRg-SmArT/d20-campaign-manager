package com.mhosler.d20_campaign_manager.controller;

import com.mhosler.d20_campaign_manager.dto.ApiError;
import com.mhosler.d20_campaign_manager.dto.InputValidationError;
import com.mhosler.d20_campaign_manager.exceptions.CampaignMembershipNotFoundException;
import com.mhosler.d20_campaign_manager.exceptions.CampaignNotFoundException;
import com.mhosler.d20_campaign_manager.exceptions.RuleNotFoundException;
import com.mhosler.d20_campaign_manager.exceptions.UserNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    @ExceptionHandler(CampaignNotFoundException.class)
    public ResponseEntity<ApiError> handleCampaignNotFound(CampaignNotFoundException e, HttpServletRequest request) {
        ApiError error = new ApiError(
                HttpStatus.NOT_FOUND,
                e.getMessage(),
                request.getRequestURI(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CampaignMembershipNotFoundException.class)
    public ResponseEntity<ApiError> handleCampaignMembershipNotFound(CampaignMembershipNotFoundException e, HttpServletRequest request) {
        ApiError error = new ApiError(
                HttpStatus.NOT_FOUND,
                e.getMessage(),
                request.getRequestURI(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<InputValidationError> handleInputValidationError(MethodArgumentNotValidException e, HttpServletRequest request) {

        List<String> errors = e.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList()
                );

        InputValidationError error = new InputValidationError(
                HttpStatus.BAD_REQUEST,
                errors,
                request.getRequestURI(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
