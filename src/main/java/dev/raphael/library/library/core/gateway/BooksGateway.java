package dev.raphael.library.library.core.gateway;

import dev.raphael.library.library.core.entities.Books;

import java.util.List;

public interface BooksGateway {

    Books addBook(Books book);

    List<Books> getBooks();
}
