package dev.raphael.library.library.core.usecases.booksUseCases;

import dev.raphael.library.library.core.entities.Books;
import dev.raphael.library.library.core.gateway.BooksGateway;

public class AddBookUseCaseImpl implements AddBookUseCase {

    private final BooksGateway booksGateway;

    public AddBookUseCaseImpl(BooksGateway booksGateway) {
        this.booksGateway = booksGateway;
    }

    @Override
    public Books execute(Books books) {
        return booksGateway.addBook(books);
    }
}
