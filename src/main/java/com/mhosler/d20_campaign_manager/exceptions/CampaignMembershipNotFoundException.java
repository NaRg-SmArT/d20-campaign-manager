package com.mhosler.d20_campaign_manager.exceptions;

public class CampaignMembershipNotFoundException extends RuntimeException {
    public CampaignMembershipNotFoundException(String message) {
        super(message);
    }
}
