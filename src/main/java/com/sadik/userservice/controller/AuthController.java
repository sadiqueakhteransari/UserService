package com.sadik.userservice.controller;

import com.sadik.userservice.dto.AuthRequest;
import com.sadik.userservice.dto.AuthResponse;
import com.sadik.userservice.dto.RegisterRequest;
import com.sadik.userservice.entity.User;
import com.sadik.userservice.service.AuthService;
import com.sadik.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AuthService authService;

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest request) {
        System.out.println("It is hit");
        return userService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        return authService.login(request);
    }
}
