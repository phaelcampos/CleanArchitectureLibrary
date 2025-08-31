package dev.raphael.library.library.core.usecases.usersUseCases;

import dev.raphael.library.library.core.entities.Users;

public interface CreateUserUseCase {

    Users execute(Users user);
}
