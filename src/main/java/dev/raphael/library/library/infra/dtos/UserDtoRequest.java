package dev.raphael.library.library.infra.dtos;

public record UserDtoRequest(
        Long id,
        String username,
        String email,
        String password
) {}
