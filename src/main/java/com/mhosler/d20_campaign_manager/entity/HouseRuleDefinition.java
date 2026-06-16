package com.mhosler.d20_campaign_manager.entity;

import jakarta.persistence.*;

@Entity
public class HouseRuleDefinition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User owner;

    private String ruleName;
    private String description;

    public HouseRuleDefinition() {
    }
    public HouseRuleDefinition(User owner, String ruleName, String description) {
        this.owner = owner;
        this.ruleName = ruleName;
        this.description = description;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }
    public void setOwner(User owner) {
        this.owner = owner;
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
