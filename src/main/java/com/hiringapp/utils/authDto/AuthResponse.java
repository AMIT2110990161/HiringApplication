package com.hiringapp.utils.authDto;

import java.io.Serializable;

public record AuthResponse(
        String message
) implements Serializable {
}
