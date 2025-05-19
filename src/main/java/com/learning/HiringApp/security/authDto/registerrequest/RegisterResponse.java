package com.learning.HiringApp.security.authDto.registerrequest;

import java.util.UUID;

public record RegisterResponse(UUID id, String email, String message) {}
