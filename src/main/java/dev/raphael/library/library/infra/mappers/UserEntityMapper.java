package dev.raphael.library.library.infra.mappers;

import dev.raphael.library.library.core.entities.Users;
import dev.raphael.library.library.infra.dtos.UserDtoRequest;
import dev.raphael.library.library.infra.dtos.UsersDtoResponse;
import dev.raphael.library.library.infra.persistence.UsersEntity;
import org.springframework.stereotype.Component;

@Component
public class UserEntityMapper {

    public UsersEntity toUserEntity(Users user) {
        return new UsersEntity(
                user.id(),
                user.username(),
                user.email(),
                user.password(),
                user.createdAt(),
                user.updatedAt()
        );
    }

    public Users toUserResponse(UsersEntity userEntity) {
        return new Users(
                userEntity.getId(),
                userEntity.getUsername(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.getCreatedAt(),
                userEntity.getUpdatedAt()
        );
    }
}
