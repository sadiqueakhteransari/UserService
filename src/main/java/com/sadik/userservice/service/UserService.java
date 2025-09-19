package com.sadik.userservice.service;

import com.sadik.userservice.dto.RegisterRequest;
import com.sadik.userservice.entity.User;

public interface UserService {
    User register(RegisterRequest request);
    User getByEmail(String email);
}
