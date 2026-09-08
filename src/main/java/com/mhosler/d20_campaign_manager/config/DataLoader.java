package com.mhosler.d20_campaign_manager.config;

import com.mhosler.d20_campaign_manager.entity.*;
import com.mhosler.d20_campaign_manager.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final HouseRuleDefinitionRepository houseRuleDefinitionRepository;
    private final CampaignRepository campaignRepository;
    private final CampaignMembershipRepository campaignMembershipRepository;
    private final SessionRepository sessionRepository;
    private final SceneRepository sceneRepository;

    public DataLoader(UserRepository userRepository,
                      HouseRuleDefinitionRepository houseRuleDefinitionRepository, CampaignRepository campaignRepository, CampaignMembershipRepository campaignMembershipRepository,  SessionRepository sessionRepository,  SceneRepository sceneRepository) {
        this.userRepository = userRepository;
        this.houseRuleDefinitionRepository = houseRuleDefinitionRepository;
        this.campaignRepository = campaignRepository;
        this.campaignMembershipRepository = campaignMembershipRepository;
        this.sessionRepository = sessionRepository;
        this.sceneRepository = sceneRepository;
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

            Session session = new Session(
                    campaign1,
                    1,
                    LocalDateTime.of(2026, 9, 8, 18, 0),
                    "The party reconvenes at the Rusty Flagon after last week's ambush. Wounds are fresh and tempers are short.",
                    "Rusty Flagon Tavern, Dawnhaven",
                    null
            );
            sessionRepository.save(session);

            Scene scene = new Scene(
                    session,
                    "The hooded figure from last session was spotted near the dockmaster's office. A street kid claims he saw them enter but never leave.",
                    "Dockmaster Errol Vance — nervous, sweating, won't make eye contact. The street kid, Pip — sharp, wants coin before he talks.",
                    "Dockmaster's office, the alley behind it, Pier 7 where an unmarked crate sits.",
                    "Crate contains smuggled spell components worth 200gp. Vance will bribe the party to stay quiet.",
                    "If ignored, the crate ships out at dawn. Vance relaxes. The hooded figure completes whatever they came for."
            );
            sceneRepository.save(scene);
        }
    }
}
