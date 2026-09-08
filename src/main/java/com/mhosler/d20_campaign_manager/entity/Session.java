package com.mhosler.d20_campaign_manager.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "campaign_id")
    private Campaign campaign;

    private int sessionNumber;
    private LocalDateTime dateTime;
    private String opening;
    private String startingLocation;
    private String closingNotes;

    public Session() {}

    public Session(Campaign campaign, int sessionNumber, LocalDateTime dateTime, String opening, String startingLocation, String closingNotes) {
        this.campaign = campaign;
        this.sessionNumber = sessionNumber;
        this.dateTime = dateTime;
        this.opening = opening;
        this.startingLocation = startingLocation;
        this.closingNotes = closingNotes;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public Campaign getCampaign() { return campaign; }
    public void setCampaign(Campaign campaign) { this.campaign = campaign; }

    public int getSessionNumber() { return sessionNumber; }
    public void setSessionNumber(int sessionNumber) { this.sessionNumber = sessionNumber; }

    public LocalDateTime getDateTime() { return dateTime; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }

    public String getOpening() { return opening; }
    public void setOpening(String opening) { this.opening = opening; }

    public String getStartingLocation() { return startingLocation; }
    public void setStartingLocation(String startingLocation) { this.startingLocation = startingLocation; }

    public String getClosingNotes() { return closingNotes; }
    public void setClosingNotes(String closingNotes) { this.closingNotes = closingNotes; }
}
