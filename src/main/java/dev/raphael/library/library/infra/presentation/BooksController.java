package dev.raphael.library.library.infra.presentation;

import dev.raphael.library.library.core.entities.Books;
import dev.raphael.library.library.core.usecases.AddBookCase;
import dev.raphael.library.library.core.usecases.SearchBookCase;
import dev.raphael.library.library.infra.dtos.BookDtoResponse;
import dev.raphael.library.library.infra.dtos.BooksDtoRequest;
import dev.raphael.library.library.infra.mappers.BooksMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BooksController {

    private final AddBookCase addBookCase;
    private final SearchBookCase searchBookCase;
    private final BooksMapper booksMapper;

    public BooksController(AddBookCase addBookCase, BooksMapper booksMapper, SearchBookCase searchBookCase) {
        this.addBookCase = addBookCase;
        this.booksMapper = booksMapper;
        this.searchBookCase = searchBookCase;
    }

    @PostMapping
    public BookDtoResponse createBook(@RequestBody BooksDtoRequest book) {
        Books newBook = addBookCase.execute(booksMapper.toDomain(book));
        return booksMapper.toBookDtoResponse(newBook);
    }

    @GetMapping
    public List<BookDtoResponse> searchBooks() {
        List<Books> booksList = searchBookCase.execute();
        return booksList.stream()
                .map(booksMapper::toBookDtoResponse)
                .toList();
    }

}
