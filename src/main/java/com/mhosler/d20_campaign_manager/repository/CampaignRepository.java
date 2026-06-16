package com.mhosler.d20_campaign_manager.repository;

import com.mhosler.d20_campaign_manager.entity.Campaign;
import com.mhosler.d20_campaign_manager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CampaignRepository extends JpaRepository<Campaign,Long> {
    List<Campaign> findByOwner(User owner);
}
