package dev.raphael.library.library.core.usecases;

import dev.raphael.library.library.core.entities.Books;

public class AddBookCaseImpl implements AddBookCase{

    @Override
    public Books execute(Books books) {
        return books;
    }
}
