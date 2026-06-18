package com.mhosler.d20_campaign_manager.dto;

public class UpdateHouseRuleRequest {
    private Long ownerId;
    private String ruleName;
    private String description;

    public UpdateHouseRuleRequest(Long ownerId, String ruleName, String description) {
        this.ownerId = ownerId;
        this.ruleName = ruleName;
        this.description = description;
    }

    public Long getOwnerId() {
        return ownerId;
    }
    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getRuleName() {
        return ruleName;
    }
    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
