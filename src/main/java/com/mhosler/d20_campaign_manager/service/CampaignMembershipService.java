package com.mhosler.d20_campaign_manager.service;

import com.mhosler.d20_campaign_manager.dto.CampaignMembershipResponse;
import com.mhosler.d20_campaign_manager.dto.CreateCampaignMembershipRequest;
import com.mhosler.d20_campaign_manager.dto.UpdateCampaignMembershipRequest;
import com.mhosler.d20_campaign_manager.entity.Campaign;
import com.mhosler.d20_campaign_manager.entity.CampaignMembership;
import com.mhosler.d20_campaign_manager.entity.Role;
import com.mhosler.d20_campaign_manager.entity.User;
import com.mhosler.d20_campaign_manager.exceptions.CampaignMembershipNotFoundException;
import com.mhosler.d20_campaign_manager.exceptions.CampaignNotFoundException;
import com.mhosler.d20_campaign_manager.exceptions.UserNotFoundException;
import com.mhosler.d20_campaign_manager.repository.CampaignMembershipRepository;
import com.mhosler.d20_campaign_manager.repository.CampaignRepository;
import com.mhosler.d20_campaign_manager.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CampaignMembershipService {

    private final CampaignMembershipRepository campaignMembershipRepository;
    private final CampaignRepository campaignRepository;
    private final UserRepository userRepository;

    public CampaignMembershipService(CampaignMembershipRepository campaignMembershipRepository, CampaignRepository campaignRepository, UserRepository userRepository) {
        this.campaignMembershipRepository = campaignMembershipRepository;
        this.campaignRepository = campaignRepository;
        this.userRepository = userRepository;
    }
    @Transactional
    public CampaignMembershipResponse createCampaignMembership(CreateCampaignMembershipRequest request) {
        User user = userRepository
                .findById(request.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User not found.")
                );
        Campaign campaign = campaignRepository
                .findById(request.getCampaignId())
                .orElseThrow(() -> new CampaignNotFoundException("Campaign not found.")
                );

        CampaignMembership membership = new CampaignMembership(user, campaign, request.getRole(), true);

        return mapToResponse(campaignMembershipRepository.save(membership));
    }

    @Transactional
    public List<CampaignMembershipResponse> getCampaignMembershipsByCampaignId(Long campaignId) {
        Campaign campaign = campaignRepository
                .findById(campaignId)
                .orElseThrow(() -> new CampaignNotFoundException("Campaign not found.")
                );
        List<CampaignMembership> memberships = campaignMembershipRepository.findByCampaign(campaign);

        List<CampaignMembershipResponse> responses = memberships.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());

        return responses;
    }

    @Transactional
    public List<CampaignMembershipResponse> getCampaignMembershipsByUserId(Long userId) {
        User user = userRepository
                .findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found.")
                );

        List<CampaignMembership> memberships = campaignMembershipRepository.findByUser(user);

        List<CampaignMembershipResponse> responses = memberships.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
        return responses;
    }

    @Transactional
    public CampaignMembershipResponse updateCampaignMembership(Long id, UpdateCampaignMembershipRequest request) {
        CampaignMembership membership = campaignMembershipRepository.findById(id)
                        .orElseThrow(() -> new CampaignMembershipNotFoundException("Campaign membership not found.")
                        );

        membership.setRole(request.getRole());
        membership.setActive(request.isActive());

        return mapToResponse(campaignMembershipRepository.save(membership));
    }

    public void deleteCampaignMembership(Long id) {
        CampaignMembership membership = campaignMembershipRepository
                .findById(id)
                .orElseThrow(() -> new CampaignMembershipNotFoundException("Campaign membership not found.")
                );

        campaignMembershipRepository.delete(membership);
    }

    private CampaignMembershipResponse mapToResponse(CampaignMembership membership) {
        Long id = membership.getId();
        Long campaignId = membership.getCampaign().getId();
        Long userId = membership.getUser().getId();
        Role role = membership.getRole();
        boolean active = membership.isActive();

        return new CampaignMembershipResponse(id, userId, campaignId, role, active);
    }
}
