package dev.raphael.library.library.infra.mappers;

import dev.raphael.library.library.core.entities.Users;
import dev.raphael.library.library.infra.dtos.UserDtoRequest;
import dev.raphael.library.library.infra.dtos.UsersDtoResponse;
import dev.raphael.library.library.infra.persistence.UsersEntity;
import org.springframework.stereotype.Component;

@Component
public class UsersDomainMapper {

    public Users toDomain(UserDtoRequest userDtoRequest) {
        return new Users(
                userDtoRequest.id(),
                userDtoRequest.username(),
                userDtoRequest.email(),
                userDtoRequest.password(),
                null, // createdAt será gerado automaticamente
                null  // updatedAt será gerado automaticamente
        );
    }

    public UsersDtoResponse toDtoResponse(Users users) {
        return new UsersDtoResponse(
                users.id(),
                users.username(),
                users.email(),
                users.password(),
                users.createdAt(),
                users.updatedAt()
        );
    }

}
