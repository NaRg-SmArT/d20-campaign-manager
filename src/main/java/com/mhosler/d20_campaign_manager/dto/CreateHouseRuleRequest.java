package com.mhosler.d20_campaign_manager.dto;

import jakarta.validation.constraints.*;


public class CreateHouseRuleRequest {
    @NotNull(message = "Owner id must not be null.")
    private long ownerId;

    @NotBlank(message = "Rule name cannot be blank.")
    @Size(max = 255, message ="Rule name cannot exceed 255 characters." )
    private String ruleName;

    @NotBlank(message = "Description cannot be blank.")
    @Size(max = 1000, message = "description cannot exceed 1000 characters.")
    private String description;

    public CreateHouseRuleRequest(long ownerId, String ruleName, String description) {
        this.ownerId = ownerId;
        this.ruleName = ruleName;
        this.description = description;
    }

    public CreateHouseRuleRequest() {

    }

    public long getOwnerId() {
        return ownerId;
    }
    public void setOwnerId(long ownerId) {
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
