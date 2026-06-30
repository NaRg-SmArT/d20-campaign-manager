package com.mhosler.d20_campaign_manager.service;

import com.mhosler.d20_campaign_manager.dto.CreateHouseRuleRequest;
import com.mhosler.d20_campaign_manager.dto.HouseRuleDefinitionResponse;
import com.mhosler.d20_campaign_manager.dto.UpdateHouseRuleRequest;
import com.mhosler.d20_campaign_manager.entity.HouseRuleDefinition;
import com.mhosler.d20_campaign_manager.entity.User;
import com.mhosler.d20_campaign_manager.exceptions.*;

import com.mhosler.d20_campaign_manager.repository.HouseRuleDefinitionRepository;
import com.mhosler.d20_campaign_manager.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HouseRuleService {

    private final HouseRuleDefinitionRepository houseRuleDefinitionRepository;
    private final UserRepository userRepository;

    public HouseRuleService(HouseRuleDefinitionRepository houseRuleDefinitionRepository, UserRepository userRepository) {
        this.houseRuleDefinitionRepository = houseRuleDefinitionRepository;
        this.userRepository = userRepository;
    }

    public List<HouseRuleDefinitionResponse> getRulesByOwner(Long ownerId) {
        User owner = userRepository.findById(ownerId)
                .orElseThrow(() -> new UserNotFoundException("User not found."));

        List<HouseRuleDefinition> rules = houseRuleDefinitionRepository.findByOwner(owner);


        List<HouseRuleDefinitionResponse> responses = rules.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());

        return responses;
    }

    public HouseRuleDefinitionResponse createHouseRule(CreateHouseRuleRequest request){
        User owner = userRepository.findById(request.getOwnerId())
                .orElseThrow(() -> new UserNotFoundException("User not found."));

        HouseRuleDefinition rule = new HouseRuleDefinition(
                owner,
                request.getRuleName(),
                request.getDescription()
        );

        return mapToResponse(houseRuleDefinitionRepository.save(rule));
    }

    public HouseRuleDefinitionResponse updateHouseRule(Long id, UpdateHouseRuleRequest request){
        HouseRuleDefinition rule = houseRuleDefinitionRepository
                .findByIdAndOwnerId(id, request.getOwnerId())
                .orElseThrow(() -> new RuleNotFoundException("Rule not found for this user."));
        rule.setRuleName(request.getRuleName());
        rule.setDescription(request.getDescription());

        return mapToResponse(houseRuleDefinitionRepository.save(rule));
    }

    public void deleteHouseRule(Long id, Long ownerId) {
        HouseRuleDefinition rule = houseRuleDefinitionRepository
                .findByIdAndOwnerId(id, ownerId)
                .orElseThrow(() -> new RuleNotFoundException("Rule not found for this user."));

        houseRuleDefinitionRepository.delete(rule);
    }

    private HouseRuleDefinitionResponse mapToResponse(HouseRuleDefinition rule) {
        Long ruleId = rule.getId();
        String ruleName = rule.getRuleName();
        String description = rule.getDescription();

        return new HouseRuleDefinitionResponse(ruleId, ruleName, description);
    }
}
