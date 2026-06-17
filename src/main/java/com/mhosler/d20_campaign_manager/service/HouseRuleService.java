package com.mhosler.d20_campaign_manager.service;

import com.mhosler.d20_campaign_manager.entity.HouseRuleDefinition;
import com.mhosler.d20_campaign_manager.entity.User;
import com.mhosler.d20_campaign_manager.repository.HouseRuleDefinitionRepository;
import com.mhosler.d20_campaign_manager.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseRuleService {

    private final HouseRuleDefinitionRepository houseRuleDefinitionRepository;
    private final UserRepository userRepository;

    public HouseRuleService(HouseRuleDefinitionRepository houseRuleDefinitionRepository, UserRepository userRepository) {
        this.houseRuleDefinitionRepository = houseRuleDefinitionRepository;
        this.userRepository = userRepository;
    }

    public List<HouseRuleDefinition> getRulesByOwner(Long ownerId) {
        User owner = userRepository.findById(ownerId)
                .orElseThrow(() -> new RuntimeException("User not found."));

        return houseRuleDefinitionRepository.findByOwner(owner);
    }
}
