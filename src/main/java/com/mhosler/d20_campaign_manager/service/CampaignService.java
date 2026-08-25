package com.mhosler.d20_campaign_manager.service;

import com.mhosler.d20_campaign_manager.dto.CampaignResponse;
import com.mhosler.d20_campaign_manager.dto.CreateCampaignRequest;
import com.mhosler.d20_campaign_manager.dto.UpdateCampaignRequest;
import com.mhosler.d20_campaign_manager.entity.Campaign;
import com.mhosler.d20_campaign_manager.entity.User;
import com.mhosler.d20_campaign_manager.exceptions.*;
import com.mhosler.d20_campaign_manager.repository.CampaignRepository;
import com.mhosler.d20_campaign_manager.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CampaignService {
    private final CampaignRepository campaignRepository;
    private final UserRepository userRepository;

    public CampaignService(CampaignRepository campaignRepository, UserRepository userRepository) {
        this.campaignRepository = campaignRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public CampaignResponse createCampaign(CreateCampaignRequest request) {
        User owner = userRepository
                .findById(request.getOwnerId())
                .orElseThrow(() -> new UserNotFoundException("User not found.")
                );

        Campaign campaign = new Campaign(owner, request.getName(), request.getSystem(), request.getDescription());

        return mapToResponse(campaignRepository.save(campaign));
    }

    @Transactional
    public List<CampaignResponse> getCampaignsByOwnerId(Long ownerId) {
        User owner = userRepository
                .findById(ownerId)
                .orElseThrow(() -> new UserNotFoundException("User not found.")
                );

        List<Campaign> campaigns = campaignRepository.findByOwner(owner);

        List<CampaignResponse> responses = campaigns.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());

        return responses;
    }

    @Transactional
    public CampaignResponse updateCampaign(Long id, UpdateCampaignRequest request) {
        Campaign campaign = campaignRepository
                .findById(id)
                .orElseThrow(() -> new CampaignNotFoundException("Campaign not found.")
                );

        campaign.setName(request.getName());
        campaign.setSystem(request.getSystem());
        campaign.setDescription(request.getDescription());

        return mapToResponse(campaignRepository.save(campaign));
    }

    public void deleteCampaign(Long id) {
        Campaign campaign = campaignRepository
                .findById(id)
                .orElseThrow(() -> new CampaignNotFoundException("Campaign not found.")
                );

        campaignRepository.delete(campaign);
    }

    private CampaignResponse mapToResponse(Campaign campaign) {
        Long id = campaign.getId();
        Long ownerId = campaign.getOwner().getId();
        String name = campaign.getName();
        String system = campaign.getSystem();
        String description = campaign.getDescription();

        return new CampaignResponse(id, ownerId, name, system, description);
    }
}
