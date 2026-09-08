package com.mhosler.d20_campaign_manager.dto;

public class SceneResponse {

    private long id;
    private long sessionId;
    private String hooks;
    private String npcs;
    private String locations;
    private String rewardsAndConsequences;
    private String passiveOutcome;

    public SceneResponse(long id, long sessionId, String hooks, String npcs, String locations, String rewardsAndConsequences, String passiveOutcome) {
        this.id = id;
        this.sessionId = sessionId;
        this.hooks = hooks;
        this.npcs = npcs;
        this.locations = locations;
        this.rewardsAndConsequences = rewardsAndConsequences;
        this.passiveOutcome = passiveOutcome;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

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
