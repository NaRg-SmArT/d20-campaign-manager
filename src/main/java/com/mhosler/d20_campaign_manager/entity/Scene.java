package com.mhosler.d20_campaign_manager.entity;

import jakarta.persistence.*;

@Entity
public class Scene {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;

    private String hooks;
    private String npcs;
    private String locations;
    private String rewardsAndConsequences;
    private String passiveOutcome;

    public Scene() {}

    public Scene(Session session, String hooks, String npcs, String locations, String rewardsAndConsequences, String passiveOutcome) {
        this.session = session;
        this.hooks = hooks;
        this.npcs = npcs;
        this.locations = locations;
        this.rewardsAndConsequences = rewardsAndConsequences;
        this.passiveOutcome = passiveOutcome;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Session getSession() { return session; }
    public void setSession(Session session) { this.session = session; }

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
