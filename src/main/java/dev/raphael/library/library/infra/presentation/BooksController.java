package dev.raphael.library.library.infra.presentation;

import dev.raphael.library.library.core.entities.Books;
import dev.raphael.library.library.core.usecases.AddBookUseCase;
import dev.raphael.library.library.core.usecases.SearchBookByIdUseCase;
import dev.raphael.library.library.core.usecases.SearchBookUseCase;
import dev.raphael.library.library.infra.dtos.BookDtoResponse;
import dev.raphael.library.library.infra.dtos.BooksDtoRequest;
import dev.raphael.library.library.infra.mappers.BooksMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BooksController {

    private final AddBookUseCase addBookUseCase;
    private final SearchBookUseCase searchBookUseCase;
    private final BooksMapper booksMapper;
    private final SearchBookByIdUseCase searchBookByIdUseCase;

    public BooksController(AddBookUseCase addBookUseCase, BooksMapper booksMapper, SearchBookUseCase searchBookUseCase, SearchBookByIdUseCase searchBookByIdUseCase) {
        this.addBookUseCase = addBookUseCase;
        this.booksMapper = booksMapper;
        this.searchBookUseCase = searchBookUseCase;
        this.searchBookByIdUseCase = searchBookByIdUseCase;
    }

    @PostMapping
    public BookDtoResponse createBook(@RequestBody BooksDtoRequest book) {
        Books newBook = addBookUseCase.execute(booksMapper.toDomain(book));
        return booksMapper.toBookDtoResponse(newBook);
    }

    @GetMapping
    public List<BookDtoResponse> searchBooks() {
        List<Books> booksList = searchBookUseCase.execute();
        return booksList.stream()
                .map(booksMapper::toBookDtoResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public Optional<BookDtoResponse> searchBookById(@PathVariable Long id) {
        Optional<Books> book = searchBookByIdUseCase.execute(id);
        return book.map(booksMapper::toBookDtoResponse);
    }

}
