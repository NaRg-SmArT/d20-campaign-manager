package com.mhosler.d20_campaign_manager.service;

import com.mhosler.d20_campaign_manager.dto.*;
import com.mhosler.d20_campaign_manager.entity.Scene;
import com.mhosler.d20_campaign_manager.entity.Session;
import com.mhosler.d20_campaign_manager.exceptions.SceneNotFoundException;
import com.mhosler.d20_campaign_manager.exceptions.SessionNotFoundException;
import com.mhosler.d20_campaign_manager.repository.SceneRepository;
import com.mhosler.d20_campaign_manager.repository.SessionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SceneService {

    private final SceneRepository sceneRepository;
    private final SessionRepository sessionRepository;

    public SceneService(SceneRepository sceneRepository, SessionRepository sessionRepository) {
        this.sceneRepository = sceneRepository;
        this.sessionRepository = sessionRepository;
    }

    @Transactional
    public List<SceneResponse> getScenesBySessionId(Long sessionId) {
        Session session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new SessionNotFoundException("Session not found: " + sessionId));
        return sceneRepository.findBySession(session).stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Transactional
    public SceneResponse createScene(CreateSceneRequest request) {
        Session session = sessionRepository.findById(request.getSessionId())
                .orElseThrow(() -> new SessionNotFoundException("Session not found: " + request.getSessionId()));
        Scene scene = new Scene(
                session,
                request.getHooks(),
                request.getNpcs(),
                request.getLocations(),
                request.getRewardsAndConsequences(),
                request.getPassiveOutcome()
        );
        return mapToResponse(sceneRepository.save(scene));
    }

    @Transactional
    public SceneResponse updateScene(Long id, UpdateSceneRequest request) {
        Session session = sessionRepository.findById(request.getSessionId())
                .orElseThrow(() -> new SessionNotFoundException("Session not found: " + request.getSessionId()));
        Scene scene = sceneRepository.findByIdAndSession(id, session)
                .orElseThrow(() -> new SceneNotFoundException("Scene not found: " + id));
        scene.setHooks(request.getHooks());
        scene.setNpcs(request.getNpcs());
        scene.setLocations(request.getLocations());
        scene.setRewardsAndConsequences(request.getRewardsAndConsequences());
        scene.setPassiveOutcome(request.getPassiveOutcome());
        return mapToResponse(sceneRepository.save(scene));
    }

    public void deleteScene(Long id) {
        Scene scene = sceneRepository.findById(id)
                .orElseThrow(() -> new SceneNotFoundException("Scene not found: " + id));
        sceneRepository.delete(scene);
    }

    private SceneResponse mapToResponse(Scene scene) {
        return new SceneResponse(
                scene.getId(),
                scene.getSession().getId(),
                scene.getHooks(),
                scene.getNpcs(),
                scene.getLocations(),
                scene.getRewardsAndConsequences(),
                scene.getPassiveOutcome()
        );
    }
}
