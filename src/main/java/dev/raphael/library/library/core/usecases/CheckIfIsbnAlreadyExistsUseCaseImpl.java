package dev.raphael.library.library.core.usecases;

import dev.raphael.library.library.core.entities.Books;
import dev.raphael.library.library.core.gateway.BooksGateway;

import java.util.Optional;

public class CheckIfIsbnAlreadyExistsUseCaseImpl implements CheckIfIsbnAlreadyExistsUseCase {

    public final BooksGateway booksGateway;

    public CheckIfIsbnAlreadyExistsUseCaseImpl(BooksGateway booksGateway) {
        this.booksGateway = booksGateway;
    }

    @Override
    public Optional<Books> execute(String isbn) {
        return booksGateway.checkIfIsbnAlreadyExists(isbn);
    }
}
