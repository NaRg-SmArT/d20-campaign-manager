package com.mhosler.d20_campaign_manager.repository;

import com.mhosler.d20_campaign_manager.entity.Campaign;
import com.mhosler.d20_campaign_manager.entity.CampaignMembership;
import com.mhosler.d20_campaign_manager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CampaignMembershipRepository extends JpaRepository<CampaignMembership, Long>{
    List<CampaignMembership> findByCampaign(Campaign campaign);
    List<CampaignMembership> findByUser(User user);
    List<CampaignMembership> findByUserAndActive(User user, boolean active);
    List<CampaignMembership> findByCampaignAndActive(Campaign campaign, boolean active);
    Optional<CampaignMembership> findByCampaignAndUser(Campaign campaign, User user);
}
