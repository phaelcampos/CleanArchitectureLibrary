package dev.raphael.library.library.infra.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import dev.raphael.library.library.core.entities.Users;
import dev.raphael.library.library.infra.persistence.UsersEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;

@Component
public class TokenService {

    @Value("${library.security.secret}")
    private String secret;

    public String generateToken(UsersEntity user) {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        return JWT.create()
                .withSubject(user.getUsername())
                .withClaim("id", user.getId())
                .withClaim("username", user.getUsername())
                .withExpiresAt(Instant.now().plusSeconds(3600))
                .withIssuedAt(Instant.now())
                .withIssuer("APIMovieFlix")
                .sign(algorithm);
    }

    public Optional<JWTUserData> verifyToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            DecodedJWT jwt = JWT.require(algorithm)
                    .build()
                    .verify(token);

            return Optional.of(JWTUserData.builder()
                    .id(jwt.getClaim("id").asLong())
                    .username(jwt.getClaim("name").asString())
                    .email(jwt.getSubject())
                    .build());
        } catch (JWTVerificationException e) {
            return Optional.empty();
        }

    }
}
