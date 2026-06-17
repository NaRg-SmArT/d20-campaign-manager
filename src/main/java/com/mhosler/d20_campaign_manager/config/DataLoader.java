package com.mhosler.d20_campaign_manager.config;

import com.mhosler.d20_campaign_manager.entity.User;
import com.mhosler.d20_campaign_manager.entity.HouseRuleDefinition;
import com.mhosler.d20_campaign_manager.repository.UserRepository;
import com.mhosler.d20_campaign_manager.repository.HouseRuleDefinitionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final HouseRuleDefinitionRepository houseRuleDefinitionRepository;

    public DataLoader(UserRepository userRepository,
                      HouseRuleDefinitionRepository houseRuleDefinitionRepository) {
        this.userRepository = userRepository;
        this.houseRuleDefinitionRepository = houseRuleDefinitionRepository;
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
        }
    }
}
