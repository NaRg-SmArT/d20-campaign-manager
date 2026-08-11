package com.mhosler.d20_campaign_manager.controller;

import com.mhosler.d20_campaign_manager.dto.CampaignMembershipResponse;
import com.mhosler.d20_campaign_manager.dto.CreateCampaignMembershipRequest;
import com.mhosler.d20_campaign_manager.dto.UpdateCampaignMembershipRequest;
import com.mhosler.d20_campaign_manager.service.CampaignMembershipService;
import jakarta.validation.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/campaign-membership")
public class CampaignMembershipController {

    private final CampaignMembershipService campaignMembershipService;

    public  CampaignMembershipController(CampaignMembershipService campaignMembershipService) {
        this.campaignMembershipService = campaignMembershipService;
    }

    @PostMapping
    public CampaignMembershipResponse createCampaignMembership(@Valid @RequestBody CreateCampaignMembershipRequest request){
        return campaignMembershipService.createCampaignMembership(request);
    }

    @GetMapping("/campaign/{campaignId}")
    public List<CampaignMembershipResponse> getMembershipsByCampaign(@PathVariable Long campaignId){
        return campaignMembershipService.getCampaignMembershipsByCampaignId(campaignId);
    }
    @GetMapping("/user/{userId}")
    public List<CampaignMembershipResponse> getMembershipsByUserId(@PathVariable Long userId){
        return campaignMembershipService.getCampaignMembershipsByUserId(userId);
    }

    @PutMapping("/{id}")
    public CampaignMembershipResponse updateCampaignMembership(@PathVariable Long id, @Valid @RequestBody UpdateCampaignMembershipRequest request){
        return campaignMembershipService.updateCampaignMembership(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteCampaignMembership(@PathVariable Long id){
        campaignMembershipService.deleteCampaignMembership(id);
    }
}
