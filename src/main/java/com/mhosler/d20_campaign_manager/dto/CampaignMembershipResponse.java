package com.mhosler.d20_campaign_manager.dto;

import com.mhosler.d20_campaign_manager.entity.Role;

public class CampaignMembershipResponse {

    private long id;
    private long userId;
    private long campaignId;
    private Role role;
    private boolean active;

    public CampaignMembershipResponse(long id, long userId, long campaignId, Role role, boolean active) {
        this.id = id;
        this.userId = userId;
        this.campaignId = campaignId;
        this.role = role;
        this.active = active;
    }

    public CampaignMembershipResponse() {

    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getCampaignId() {
        return campaignId;
    }
    public void setCampaignId(long campaignId) {
        this.campaignId = campaignId;
    }

    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
}
