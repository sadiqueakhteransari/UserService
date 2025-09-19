package com.sadik.userservice.controller;

import com.sadik.userservice.dto.UserSummary;
import com.sadik.userservice.entity.User;
import com.sadik.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    // 👤 Protected endpoint: requires a valid JWT
    @GetMapping("/me")
    public UserSummary getCurrentUser(Authentication authentication) {
        String email = authentication.getName(); // JWT subject
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return new UserSummary(
                user.getId(),
                user.getEmail(),
                user.getFullName()
        );
    }
}
