package com.mhosler.d20_campaign_manager.dto;

import com.mhosler.d20_campaign_manager.security.ValidPassword;
import jakarta.validation.constraints.*;



public class CreateUserRequest {
    @NotBlank(message = "Username cannot be blank.")
    @Size(max = 50, message = "Username cannot exceed 50 characters.")
    private String username;

    @NotBlank(message = "Email cannot be blank.")
    private String email;

    @NotBlank
    @ValidPassword
    private String password;

    public CreateUserRequest() {

    }

    public CreateUserRequest(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
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

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
