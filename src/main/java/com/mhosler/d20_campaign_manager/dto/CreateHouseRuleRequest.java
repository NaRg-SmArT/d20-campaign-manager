package com.mhosler.d20_campaign_manager.dto;

import jakarta.validation.constraints.*;


public class CreateHouseRuleRequest {
    @NotNull
    private Long ownerId;

    @NotBlank
    @Size(max = 255)
    private String ruleName;

    @Size(max = 1000)
    private String description;

    public CreateHouseRuleRequest(Long ownerId, String ruleName, String description) {
        this.ownerId = ownerId;
        this.ruleName = ruleName;
        this.description = description;
    }

    public CreateHouseRuleRequest() {

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
