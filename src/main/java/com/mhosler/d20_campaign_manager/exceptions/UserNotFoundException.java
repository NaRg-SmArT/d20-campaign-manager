package com.mhosler.d20_campaign_manager.exceptions;

public class UserNotFoundException extends RuntimeException {
    public  UserNotFoundException(String message) {
        super(message);
    }
}
