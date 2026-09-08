package com.mhosler.d20_campaign_manager.controller;

import com.mhosler.d20_campaign_manager.dto.CampaignResponse;
import com.mhosler.d20_campaign_manager.dto.CreateCampaignRequest;
import com.mhosler.d20_campaign_manager.dto.UpdateCampaignRequest;
import com.mhosler.d20_campaign_manager.service.CampaignService;
import jakarta.validation.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/campaign")
public class CampaignController {
    private final CampaignService campaignService;

    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @PostMapping
    public CampaignResponse createCampaign(@Valid @RequestBody CreateCampaignRequest request) {
        return campaignService.createCampaign(request);
    }

    @GetMapping
    public List<CampaignResponse> getCampaignsByOwnerId(@RequestParam long ownerId) {
        return campaignService.getCampaignsByOwnerId(ownerId);
    }

    @PutMapping("/{id}")
    public CampaignResponse updateCampaign(@PathVariable long id, @Valid @RequestBody UpdateCampaignRequest request) {
        return campaignService.updateCampaign(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteCampaign(@PathVariable long id) {
        campaignService.deleteCampaign(id);
    }
}
