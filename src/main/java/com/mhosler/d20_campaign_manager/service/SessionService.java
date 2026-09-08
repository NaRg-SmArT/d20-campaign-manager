package com.mhosler.d20_campaign_manager.service;

import com.mhosler.d20_campaign_manager.controller.dto.*;
import com.mhosler.d20_campaign_manager.entity.Campaign;
import com.mhosler.d20_campaign_manager.entity.Session;
import com.mhosler.d20_campaign_manager.exceptions.CampaignNotFoundException;
import com.mhosler.d20_campaign_manager.exceptions.SessionNotFoundException;
import com.mhosler.d20_campaign_manager.repository.CampaignRepository;
import com.mhosler.d20_campaign_manager.repository.SessionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SessionService {

    private final SessionRepository sessionRepository;
    private final CampaignRepository campaignRepository;

    public SessionService(SessionRepository sessionRepository, CampaignRepository campaignRepository) {
        this.sessionRepository = sessionRepository;
        this.campaignRepository = campaignRepository;
    }

    @Transactional
    public List<SessionResponse> getSessionsByCampaignId(Long campaignId) {
        Campaign campaign = campaignRepository.findById(campaignId)
                .orElseThrow(() -> new CampaignNotFoundException("Campaign not found: " + campaignId));
        return sessionRepository.findByCampaign(campaign).stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Transactional
    public SessionResponse createSession(CreateSessionRequest request) {
        Campaign campaign = campaignRepository.findById(request.getCampaignId())
                .orElseThrow(() -> new CampaignNotFoundException("Campaign not found: " + request.getCampaignId()));
        Session session = new Session(
                campaign,
                request.getSessionNumber(),
                request.getDateTime(),
                request.getOpening(),
                request.getStartingLocation(),
                request.getClosingNotes()
        );
        return mapToResponse(sessionRepository.save(session));
    }

    @Transactional
    public SessionResponse updateSession(Long id, UpdateSessionRequest request) {
        Campaign campaign = campaignRepository.findById(request.getCampaignId())
                .orElseThrow(() -> new CampaignNotFoundException("Campaign not found: " + request.getCampaignId()));
        Session session = sessionRepository.findByIdAndCampaign(id, campaign)
                .orElseThrow(() -> new SessionNotFoundException("Session not found: " + id));
        session.setSessionNumber(request.getSessionNumber());
        session.setDateTime(request.getDateTime());
        session.setOpening(request.getOpening());
        session.setStartingLocation(request.getStartingLocation());
        session.setClosingNotes(request.getClosingNotes());
        return mapToResponse(sessionRepository.save(session));
    }

    public void deleteSession(Long id) {
        Session session = sessionRepository.findById(id)
                .orElseThrow(() -> new SessionNotFoundException("Session not found: " + id));
        sessionRepository.delete(session);
    }

    private SessionResponse mapToResponse(Session session) {
        return new SessionResponse(
                session.getId(),
                session.getCampaign().getId(),
                session.getSessionNumber(),
                session.getDateTime(),
                session.getOpening(),
                session.getStartingLocation(),
                session.getClosingNotes()
        );
    }
}
