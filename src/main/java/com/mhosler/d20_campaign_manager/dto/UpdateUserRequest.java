package com.mhosler.d20_campaign_manager.dto;

import com.mhosler.d20_campaign_manager.security.ValidPassword;
import jakarta.validation.constraints.*;

public class UpdateUserRequest {

    @NotBlank(message = "Username cannot be blank.")
    @Size(max = 50, message = "Username cannot exceed 50 characters.")
    private String username;

    @NotBlank(message = "Email must not be blank.")
    private String email;

    public UpdateUserRequest() {
    }

    public UpdateUserRequest(String username, String email) {
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
