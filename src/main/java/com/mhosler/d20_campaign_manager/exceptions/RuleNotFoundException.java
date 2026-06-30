package com.mhosler.d20_campaign_manager.exceptions;

public class RuleNotFoundException extends RuntimeException {
    public RuleNotFoundException(String message) {
        super(message);
    }
}
