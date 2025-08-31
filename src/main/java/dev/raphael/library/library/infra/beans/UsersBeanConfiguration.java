package dev.raphael.library.library.infra.beans;

import dev.raphael.library.library.core.gateway.UsersGateway;
import dev.raphael.library.library.core.usecases.usersUseCases.CreateUserUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsersBeanConfiguration {

    @Bean
    public CreateUserUseCaseImpl createUser(UsersGateway usersGateway) { return  new CreateUserUseCaseImpl(usersGateway);}
}
