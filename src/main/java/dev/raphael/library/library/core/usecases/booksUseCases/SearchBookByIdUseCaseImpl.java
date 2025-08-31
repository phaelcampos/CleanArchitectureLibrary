package dev.raphael.library.library.core.usecases.booksUseCases;

import dev.raphael.library.library.core.entities.Books;
import dev.raphael.library.library.core.gateway.BooksGateway;

import java.util.Optional;

public class SearchBookByIdUseCaseImpl implements SearchBookByIdUseCase {

    public final BooksGateway booksGateway;

    public SearchBookByIdUseCaseImpl(BooksGateway booksGateway) {
        this.booksGateway = booksGateway;
    }

    @Override
    public Optional<Books> execute(Long id) {
        return booksGateway.getBookById(id);
    }

}
