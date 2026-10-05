package com.mhosler.d20_campaign_manager.service;

import com.mhosler.d20_campaign_manager.dto.CreateCampaignMembershipRequest;
import com.mhosler.d20_campaign_manager.entity.Role;
import com.mhosler.d20_campaign_manager.entity.User;
import com.mhosler.d20_campaign_manager.exceptions.CampaignNotFoundException;
import com.mhosler.d20_campaign_manager.exceptions.UserNotFoundException;
import com.mhosler.d20_campaign_manager.repository.CampaignMembershipRepository;
import com.mhosler.d20_campaign_manager.repository.CampaignRepository;
import com.mhosler.d20_campaign_manager.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.*;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;


import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CampaignMembershipServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private CampaignRepository campaignRepository;
    @Mock
    private CampaignMembershipRepository campaignMembershipRepository;

    @InjectMocks
    private CampaignMembershipService campaignMembershipService;

    @Test
    void createCampaignMembership_userNotFound_throwsAndSavesNothing() {

        CreateCampaignMembershipRequest request = new CreateCampaignMembershipRequest(1L, 2L, Role.GM );

        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> campaignMembershipService.createCampaignMembership(request))
                .isInstanceOf(UserNotFoundException.class);

        verify(campaignMembershipRepository, never()).save(any());
    }

    @Test
    void createCampaignMembership_campaignNotFound_throwsAndSavesNothing() {

        User user = new User("Sting", "feyd_rautha@thepolice.com", "D0n'tSt@ndS0Clo$eToMe" );
        user.setId(1L);

        CreateCampaignMembershipRequest request = new CreateCampaignMembershipRequest(user.getId(), 2L, Role.GM );

        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        when(campaignRepository.findById(2L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> campaignMembershipService.createCampaignMembership(request))
            .isInstanceOf(CampaignNotFoundException.class);

        verify(campaignMembershipRepository, never()).save(any());

    }
}
