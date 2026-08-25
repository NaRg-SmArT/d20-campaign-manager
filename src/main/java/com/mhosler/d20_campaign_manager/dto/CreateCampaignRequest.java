package com.mhosler.d20_campaign_manager.dto;

import jakarta.validation.constraints.*;

public class CreateCampaignRequest {
    @NotNull(message = "Owner Id must not be null.")
    private Long ownerId;

    @NotBlank(message = "Name must not be blank.")
    @Size(max = 50, message = "Name must not exceed 50 characters.")
    private String name;

    @NotBlank(message = "System must not be blank.")
    @Size(max = 50, message = "System must not exceed 50 characters.")
    private String system;

    @NotBlank(message = "Description must not be blank.")
    @Size(max = 500, message = "description must not exceed 500 characters.")
    private String description;

    public CreateCampaignRequest(Long ownerId, String name, String system, String description) {
        this.ownerId = ownerId;
        this.name = name;
        this.system = system;
        this.description = description;
    }
    public CreateCampaignRequest() {

    }

    public Long getOwnerId() {
        return ownerId;
    }
    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
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
