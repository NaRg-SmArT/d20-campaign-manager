package com.mhosler.d20_campaign_manager.dto;

import com.mhosler.d20_campaign_manager.entity.Role;
import jakarta.validation.constraints.*;

public class UpdateCampaignMembershipRequest {

    @NotNull
    private Role role;

    private boolean active;

    public UpdateCampaignMembershipRequest(Role role, boolean active) {
        this.role = role;
        this.active = active;
    }

    public UpdateCampaignMembershipRequest() {

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
