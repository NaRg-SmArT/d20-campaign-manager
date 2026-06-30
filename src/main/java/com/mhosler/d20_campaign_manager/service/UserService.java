package com.mhosler.d20_campaign_manager.service;


import com.mhosler.d20_campaign_manager.dto.CreateUserRequest;
import com.mhosler.d20_campaign_manager.dto.UpdateUserRequest;
import com.mhosler.d20_campaign_manager.dto.UserResponse;
import com.mhosler.d20_campaign_manager.entity.User;
import com.mhosler.d20_campaign_manager.exceptions.*;
import com.mhosler.d20_campaign_manager.repository.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse createUser(CreateUserRequest request) {
        User user = new User(request.getUsername(), request.getEmail());

        return mapToResponse(userRepository.save(user));
    }

    public UserResponse updateUser(Long id, UpdateUserRequest request) {
        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found."));

        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());

        return mapToResponse(userRepository.save(user));
    }

    public void  deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found."));
        userRepository.delete(user);
    }

    private UserResponse mapToResponse(User user) {
        Long id = user.getId();
        String username = user.getUsername();
        String email = user.getEmail();

        return new UserResponse(id, username, email);
    }

}
