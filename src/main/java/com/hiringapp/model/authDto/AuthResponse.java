package com.hiringapp.model.authDto;

import java.io.Serializable;

public record AuthResponse(
        String message
) implements Serializable {
}