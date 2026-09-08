package com.mhosler.d20_campaign_manager.dto;

public class CampaignResponse {
    private long id;
    private long ownerId;
    private String name;
    private String system;
    private String description;

    public CampaignResponse(long id, long ownerId, String name, String system, String description) {
        this.id = id;
        this.ownerId = ownerId;
        this.name = name;
        this.system = system;
        this.description = description;
    }
    public CampaignResponse() {

    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public long getOwnerId() {
        return ownerId;
    }
    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSystem() {
        return system;
    }
    public void setSystem(String system) {
        this.system = system;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
