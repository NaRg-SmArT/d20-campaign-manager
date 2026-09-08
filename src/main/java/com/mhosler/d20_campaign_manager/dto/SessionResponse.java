package com.mhosler.d20_campaign_manager.dto;

import java.time.LocalDateTime;

public class SessionResponse {

    private Long id;
    private Long campaignId;
    private int sessionNumber;
    private LocalDateTime dateTime;
    private String opening;
    private String startingLocation;
    private String closingNotes;

    public SessionResponse(Long id, Long campaignId, int sessionNumber, LocalDateTime dateTime, String opening, String startingLocation, String closingNotes) {
        this.id = id;
        this.campaignId = campaignId;
        this.sessionNumber = sessionNumber;
        this.dateTime = dateTime;
        this.opening = opening;
        this.startingLocation = startingLocation;
        this.closingNotes = closingNotes;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getCampaignId() { return campaignId; }
    public void setCampaignId(Long campaignId) { this.campaignId = campaignId; }

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
