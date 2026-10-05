package com.mhosler.d20_campaign_manager.service;

import com.mhosler.d20_campaign_manager.dto.CreateUserRequest;
import com.mhosler.d20_campaign_manager.entity.User;
import com.mhosler.d20_campaign_manager.repository.UserRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void createUser_storesPassword() {
        String password = "D0n'tSt@ndS0Clo$eToMe";
        CreateUserRequest request = new CreateUserRequest("Sting", "feyd_rautha@thepolice.com", password );

        when(userRepository.save(any(User.class)))
                .thenAnswer(invocation -> {
                    User user = invocation.getArgument(0);
                    user.setId(1L);
                    return user;});

        userService.createUser(request);

        ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);
        verify(userRepository).save(captor.capture());
        User saved =  captor.getValue();

        assertThat(saved.getPassword()).isEqualTo(password);
    }
}
