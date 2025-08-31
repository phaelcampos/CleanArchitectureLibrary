package dev.raphael.library.library.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Long> {
    Optional<UserDetails> findUserByEmail(String email);
}
