package com.mhosler.d20_campaign_manager.dto;

import com.mhosler.d20_campaign_manager.entity.Role;
import jakarta.validation.constraints.*;

public class CreateCampaignMembershipRequest {

    @NotNull(message = "User id must not be null.")
    private long userId;

    @NotNull(message = "Campaign id must not be null.")
    private long campaignId;

    @NotNull(message = "Role must not be null.")
    private Role role;

    public CreateCampaignMembershipRequest(long userId, long campaignId, Role role) {
        this.userId = userId;
        this.campaignId = campaignId;
        this.role = role;
    }

    public CreateCampaignMembershipRequest() {
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
}
