package dev.raphael.library.library.core.usecases;

import dev.raphael.library.library.core.entities.Books;

import java.util.List;

public interface SearchBookUseCase {

    public List<Books> execute();
}
