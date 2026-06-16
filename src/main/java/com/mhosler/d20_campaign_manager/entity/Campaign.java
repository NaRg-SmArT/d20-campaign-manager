package com.mhosler.d20_campaign_manager.entity;

import jakarta.persistence.*;

@Entity
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User owner;

    private String name;
    private String system;
    private String description;

    public Campaign() {

    }

    public Campaign(User owner, String name, String system, String description) {
        this.owner = owner;
        this.name = name;
        this.system = system;
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
