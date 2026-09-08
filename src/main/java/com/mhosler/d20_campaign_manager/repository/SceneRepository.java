package com.mhosler.d20_campaign_manager.repository;

import com.mhosler.d20_campaign_manager.entity.Scene;
import com.mhosler.d20_campaign_manager.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SceneRepository extends JpaRepository<Scene, Long> {
    List<Scene> findBySession(Session session);
    Optional<Scene> findByIdAndSession(Long id, Session session);
}
