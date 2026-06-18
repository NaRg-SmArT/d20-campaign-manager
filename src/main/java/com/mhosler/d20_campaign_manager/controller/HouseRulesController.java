package com.mhosler.d20_campaign_manager.controller;

import com.mhosler.d20_campaign_manager.dto.CreateHouseRuleRequest;
import com.mhosler.d20_campaign_manager.dto.UpdateHouseRuleRequest;
import com.mhosler.d20_campaign_manager.entity.HouseRuleDefinition;
import com.mhosler.d20_campaign_manager.service.HouseRuleService;
import jakarta.validation.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/house-rules")
public class HouseRulesController {

    private final HouseRuleService houseRuleService;

    public HouseRulesController(HouseRuleService houseRuleService) {
        this.houseRuleService = houseRuleService;
    }

    @GetMapping
    List<HouseRuleDefinition> getHouseRules(@RequestParam Long ownerId){
        return houseRuleService.getRulesByOwner(ownerId);
    }

    @PostMapping
    public HouseRuleDefinition createHouseRule(@Valid @RequestBody CreateHouseRuleRequest request){
        return houseRuleService.createHouseRule(request);
    }

    @PutMapping("/{id}")
    public HouseRuleDefinition updateHouseRule(@PathVariable Long id, @Valid @RequestBody UpdateHouseRuleRequest request){
        return houseRuleService.updateHouseRule(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteHouseRule(@PathVariable Long id, @RequestParam Long ownerId){
        houseRuleService.deleteHouseRule(id, ownerId);
    }
}
