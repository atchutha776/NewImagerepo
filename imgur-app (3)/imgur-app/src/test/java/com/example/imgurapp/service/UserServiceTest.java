package com.example.imgurapp.service;

import com.example.imgurapp.model.User;
import com.example.imgurapp.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    private User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        user = new User();
        user.setUsername("testuser");
        user.setPassword("testpassword");
    }

    @Test
    void registerUser() {
        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");
        when(userRepository.save(any(User.class))).thenReturn(user);

        String result = userService.registerUser(user);

        assertEquals("User registered successfully", result);
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void getUser_InvalidCredentials() {
        when(userRepository.findByUsername("testuser")).thenReturn(null);

        assertThrows(RuntimeException.class, () -> userService.getUser("testuser", "wrongpassword"));
    }
}