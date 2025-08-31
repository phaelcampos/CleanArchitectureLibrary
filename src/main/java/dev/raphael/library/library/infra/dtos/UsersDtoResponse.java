package dev.raphael.library.library.infra.dtos;

import java.time.LocalDateTime;

public record UsersDtoResponse (
        Long id,
        String username,
        String email,
        String password,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
){}
