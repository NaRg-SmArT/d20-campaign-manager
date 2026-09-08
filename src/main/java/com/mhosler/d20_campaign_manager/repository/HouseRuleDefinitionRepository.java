package com.mhosler.d20_campaign_manager.repository;

import com.mhosler.d20_campaign_manager.entity.HouseRuleDefinition;
import com.mhosler.d20_campaign_manager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HouseRuleDefinitionRepository extends JpaRepository<HouseRuleDefinition,Integer> {
    List<HouseRuleDefinition> findByOwner(User owner);

    Optional<HouseRuleDefinition> findByIdAndOwnerId(long id, long ownerId);
}
