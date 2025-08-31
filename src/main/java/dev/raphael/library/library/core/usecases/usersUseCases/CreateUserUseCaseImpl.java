package dev.raphael.library.library.core.usecases.usersUseCases;

import dev.raphael.library.library.core.entities.Users;
import dev.raphael.library.library.core.gateway.UsersGateway;

public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UsersGateway usersGateway;

    public CreateUserUseCaseImpl(UsersGateway usersGateway) {
        this.usersGateway = usersGateway;
    }

    @Override
    public Users execute(Users user) {
        return usersGateway.createUser(user);
    }
}
