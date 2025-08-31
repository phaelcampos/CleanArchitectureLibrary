package dev.raphael.library.library.core.usecases.booksUseCases;

import dev.raphael.library.library.core.entities.Books;
import dev.raphael.library.library.core.gateway.BooksGateway;

import java.util.List;

public class SearchBookUseCaseImpl implements SearchBookUseCase {

    private final BooksGateway booksGateway;

    public SearchBookUseCaseImpl(BooksGateway booksGateway) {
        this.booksGateway = booksGateway;
    }

    @Override
    public List<Books> execute() {
        return booksGateway.getBooks();
    }
}
