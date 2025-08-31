package dev.raphael.library.library.infra.presentation;

import dev.raphael.library.library.core.entities.Users;
import dev.raphael.library.library.core.usecases.usersUseCases.CreateUserUseCase;
import dev.raphael.library.library.infra.config.TokenService;
import dev.raphael.library.library.infra.dtos.LoginRequest;
import dev.raphael.library.library.infra.dtos.LoginResponse;
import dev.raphael.library.library.infra.dtos.UserDtoRequest;
import dev.raphael.library.library.infra.exceptions.UsernameOrPasswordInvalidException;
import dev.raphael.library.library.infra.mappers.UsersDomainMapper;
import dev.raphael.library.library.infra.persistence.UsersEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final CreateUserUseCase createUserUseCase;
    private final UsersDomainMapper usersDomainMapper;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;


    public UsersController(CreateUserUseCase createUserUseCase, UsersDomainMapper usersDomainMapper, AuthenticationManager authenticationManager, TokenService tokenService) {
        this.createUserUseCase = createUserUseCase;
        this.usersDomainMapper = usersDomainMapper;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> createUser(@RequestBody UserDtoRequest user) {
        Users savedUser = createUserUseCase.execute(usersDomainMapper.toDomain(user));
        Map<String, Object> response = new HashMap<>();
        response.put("Book:", usersDomainMapper.toDtoResponse(savedUser));
        response.put("Message:", "User created successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request){
        try{

            UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(request.email(), request.password());
            Authentication authenticate = authenticationManager.authenticate(userAndPass);

            UsersEntity user = (UsersEntity) authenticate.getPrincipal();
            String token = tokenService.generateToken(user);
            return ResponseEntity.ok(new LoginResponse(token));

        }catch (BadCredentialsException e){
            throw new UsernameOrPasswordInvalidException("Username or password is invalid");
        }
    }
}
