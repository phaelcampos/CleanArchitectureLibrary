package dev.raphael.library.library.infra.config;

import lombok.Builder;

@Builder
public record JWTUserData(Long id, String email, String username) {
}
