package com.mhosler.d20_campaign_manager.dto;

import jakarta.validation.constraints.*;

public class CreateUserRequest {
    @NotBlank
    @Size(max = 50)
    private String username;
    @NotBlank
    private String email;

    public CreateUserRequest() {

    }

    public CreateUserRequest(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
