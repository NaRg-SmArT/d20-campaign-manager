package com.mhosler.d20_campaign_manager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UpdateSceneRequest {

    @NotNull(message = "Session ID is required")
    private long sessionId;

    @NotBlank(message = "Hooks are required")
    @Size(max = 2000, message = "Hooks must not exceed 2000 characters")
    private String hooks;

    @Size(max = 2000, message = "NPCs must not exceed 2000 characters")
    private String npcs;

    @Size(max = 2000, message = "Locations must not exceed 2000 characters")
    private String locations;

    @Size(max = 2000, message = "Rewards and consequences must not exceed 2000 characters")
    private String rewardsAndConsequences;

    @Size(max = 2000, message = "Passive outcome must not exceed 2000 characters")
    private String passiveOutcome;

    public long getSessionId() { return sessionId; }
    public void setSessionId(long sessionId) { this.sessionId = sessionId; }

    public String getHooks() { return hooks; }
    public void setHooks(String hooks) { this.hooks = hooks; }

    public String getNpcs() { return npcs; }
    public void setNpcs(String npcs) { this.npcs = npcs; }

    public String getLocations() { return locations; }
    public void setLocations(String locations) { this.locations = locations; }

    public String getRewardsAndConsequences() { return rewardsAndConsequences; }
    public void setRewardsAndConsequences(String rewardsAndConsequences) { this.rewardsAndConsequences = rewardsAndConsequences; }

    public String getPassiveOutcome() { return passiveOutcome; }
    public void setPassiveOutcome(String passiveOutcome) { this.passiveOutcome = passiveOutcome; }
}
