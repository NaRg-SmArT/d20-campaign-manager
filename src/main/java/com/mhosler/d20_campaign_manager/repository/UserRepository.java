package com.mhosler.d20_campaign_manager.repository;

import com.mhosler.d20_campaign_manager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
