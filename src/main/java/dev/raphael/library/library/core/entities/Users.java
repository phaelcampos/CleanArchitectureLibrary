package dev.raphael.library.library.core.entities;

import java.time.LocalDateTime;

public record Users(
        Long id,

        String username,

        String email,

        String password,

        LocalDateTime createdAt,

        LocalDateTime updatedAt
){}
