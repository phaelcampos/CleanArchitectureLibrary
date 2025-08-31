package dev.raphael.library.library.infra.gateway;


import dev.raphael.library.library.core.entities.Users;
import dev.raphael.library.library.core.gateway.UsersGateway;
import dev.raphael.library.library.infra.mappers.UserEntityMapper;
import dev.raphael.library.library.infra.mappers.UsersDomainMapper;
import dev.raphael.library.library.infra.persistence.UsersEntity;
import dev.raphael.library.library.infra.persistence.UsersRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UsersRepositoryGateway implements UsersGateway {

    private final UsersRepository usersRepository;
    private final UserEntityMapper userEntityMapper;
    private final PasswordEncoder passwordEncoder;

    public UsersRepositoryGateway(UsersRepository usersRepository, UserEntityMapper userEntityMapper, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.userEntityMapper = userEntityMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Users createUser(Users user) {
        UsersEntity usersEntity = userEntityMapper.toUserEntity(user);
        String password = usersEntity.getPassword();
        usersEntity.setPassword(passwordEncoder.encode(password));
        UsersEntity savedUser = usersRepository.save(usersEntity);
        return userEntityMapper.toUserResponse(savedUser);
    }
}

