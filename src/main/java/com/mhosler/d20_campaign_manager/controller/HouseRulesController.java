package com.mhosler.d20_campaign_manager.controller;

import com.mhosler.d20_campaign_manager.entity.HouseRuleDefinition;
import com.mhosler.d20_campaign_manager.entity.User;
import com.mhosler.d20_campaign_manager.service.HouseRuleService;
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
}
