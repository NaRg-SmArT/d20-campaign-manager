package com.mhosler.d20_campaign_manager.dto;

import com.mhosler.d20_campaign_manager.entity.Role;
import jakarta.validation.constraints.*;

public class CreateCampaignMembershipRequest {

    @NotNull(message = "User id must not be null.")
    private Long userId;

    @NotNull(message = "Campaign id must not be null.")
    private Long campaignId;

    @NotNull(message = "Role must not be null.")
    private Role role;

    public CreateCampaignMembershipRequest(Long userId, Long campaignId, Role role) {
        this.userId = userId;
        this.campaignId = campaignId;
        this.role = role;
    }

    public CreateCampaignMembershipRequest() {
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
}
