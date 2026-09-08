package com.mhosler.d20_campaign_manager.dto;

public class HouseRuleDefinitionResponse {

    private long id;
    private String ruleName;
    private String description;

    public HouseRuleDefinitionResponse() {

    }

    public HouseRuleDefinitionResponse(long id, String ruleName, String description) {
        this.id = id;
        this.ruleName = ruleName;
        this.description = description;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
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
