package dev.raphael.library.library.core.usecases;

import dev.raphael.library.library.core.entities.Books;

public class SearchBookCaseImpl implements SearchBookCase {

    @Override
    public Books execute(Books books) {
        return books;
    }
}
