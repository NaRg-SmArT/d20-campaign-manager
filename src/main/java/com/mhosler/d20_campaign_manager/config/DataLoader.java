package com.mhosler.d20_campaign_manager.config;

import com.mhosler.d20_campaign_manager.entity.*;
import com.mhosler.d20_campaign_manager.repository.CampaignMembershipRepository;
import com.mhosler.d20_campaign_manager.repository.CampaignRepository;
import com.mhosler.d20_campaign_manager.repository.UserRepository;
import com.mhosler.d20_campaign_manager.repository.HouseRuleDefinitionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final HouseRuleDefinitionRepository houseRuleDefinitionRepository;
    private final CampaignRepository campaignRepository;
    private final CampaignMembershipRepository campaignMembershipRepository;

    public DataLoader(UserRepository userRepository,
                      HouseRuleDefinitionRepository houseRuleDefinitionRepository, CampaignRepository campaignRepository, CampaignMembershipRepository campaignMembershipRepository) {
        this.userRepository = userRepository;
        this.houseRuleDefinitionRepository = houseRuleDefinitionRepository;
        this.campaignRepository = campaignRepository;
        this.campaignMembershipRepository = campaignMembershipRepository;
    }

    @Override
    public void run(String... args) {
        if (userRepository.count() == 0) {
            User user = new User("test_dm", "test@example.com");
            userRepository.save(user);

            HouseRuleDefinition rule1 =
                    new HouseRuleDefinition(user, "Max HP at Level 1", "Players start with maximum HP at level 1");
            HouseRuleDefinition rule2 =
                    new HouseRuleDefinition(user, "Milestone Leveling", "XP is ignored; leveling is by milestones");

            houseRuleDefinitionRepository.save(rule1);
            houseRuleDefinitionRepository.save(rule2);

            Campaign campaign1 = new Campaign(user, "test_campaign", "ShadowDark",  "Campaign to test membership endpoint");
            campaignRepository.save(campaign1);

            CampaignMembership testMembership = new CampaignMembership(user, campaign1, Role.GM, true);

            campaignMembershipRepository.save(testMembership);
        }
    }
}
