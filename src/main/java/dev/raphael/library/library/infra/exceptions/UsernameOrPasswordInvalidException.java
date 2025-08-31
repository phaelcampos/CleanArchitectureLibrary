package dev.raphael.library.library.infra.exceptions;

public class UsernameOrPasswordInvalidException extends RuntimeException{

    public UsernameOrPasswordInvalidException(String message) {
        super(message);
    }
}
