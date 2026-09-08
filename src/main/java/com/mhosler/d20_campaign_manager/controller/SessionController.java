package com.mhosler.d20_campaign_manager.controller;

import com.mhosler.d20_campaign_manager.dto.CreateSessionRequest;
import com.mhosler.d20_campaign_manager.dto.SessionResponse;
import com.mhosler.d20_campaign_manager.dto.UpdateSessionRequest;
import com.mhosler.d20_campaign_manager.service.SessionService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/session")
public class SessionController {

    private final SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping
    public List<SessionResponse> getSessionsByCampaignId(@RequestParam Long campaignId) {
        return sessionService.getSessionsByCampaignId(campaignId);
    }

    @PostMapping
    public SessionResponse createSession(@Valid @RequestBody CreateSessionRequest request) {
        return sessionService.createSession(request);
    }

    @PutMapping("/{id}")
    public SessionResponse updateSession(@PathVariable Long id, @Valid @RequestBody UpdateSessionRequest request) {
        return sessionService.updateSession(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteSession(@PathVariable Long id) {
        sessionService.deleteSession(id);
    }
}
