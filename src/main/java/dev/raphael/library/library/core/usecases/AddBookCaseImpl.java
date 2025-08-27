package dev.raphael.library.library.core.usecases;

import dev.raphael.library.library.core.entities.Books;
import dev.raphael.library.library.core.gateway.BooksGateway;

public class AddBookCaseImpl implements AddBookCase{

    private final BooksGateway booksGateway;

    public AddBookCaseImpl(BooksGateway booksGateway) {
        this.booksGateway = booksGateway;
    }

    @Override
    public Books execute(Books books) {
        return booksGateway.addBook(books);
    }
}
