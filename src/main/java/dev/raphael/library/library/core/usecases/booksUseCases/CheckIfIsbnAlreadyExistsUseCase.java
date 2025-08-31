package dev.raphael.library.library.core.usecases.booksUseCases;

import dev.raphael.library.library.core.entities.Books;

import java.util.Optional;

public interface CheckIfIsbnAlreadyExistsUseCase {

    Optional<Books> execute(String isbn);
}
