package com.sadik.userservice.dto;

import java.util.UUID;

public record UserSummary(UUID id, String email, String fullName) {}
