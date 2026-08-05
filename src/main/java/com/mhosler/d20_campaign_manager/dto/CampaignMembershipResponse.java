package com.mhosler.d20_campaign_manager.dto;

import com.mhosler.d20_campaign_manager.entity.Role;

public class CampaignMembershipResponse {

    private Long id;
    private Long userId;
    private Long campaignId;
    private Role role;
    private boolean active;

    public CampaignMembershipResponse(Long id, Long userId, Long campaignId, Role role, boolean active) {
        this.id = id;
        this.userId = userId;
        this.campaignId = campaignId;
        this.role = role;
        this.active = active;
    }

    public CampaignMembershipResponse() {

    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCampaignId() {
        return campaignId;
    }
    public void setCampaignId(Long campaignId) {
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
