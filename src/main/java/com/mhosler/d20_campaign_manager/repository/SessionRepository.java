package com.mhosler.d20_campaign_manager.repository;

import com.mhosler.d20_campaign_manager.entity.Campaign;
import com.mhosler.d20_campaign_manager.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SessionRepository extends JpaRepository<Session, Long> {
    List<Session> findByCampaign(Campaign campaign);
    Optional<Session> findByIdAndCampaign(Long id, Campaign campaign);;
}
