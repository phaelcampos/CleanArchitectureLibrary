package dev.raphael.library.library.infra.presentation;

import dev.raphael.library.library.core.entities.Books;
import dev.raphael.library.library.core.usecases.booksUseCases.AddBookUseCase;
import dev.raphael.library.library.core.usecases.booksUseCases.CheckIfIsbnAlreadyExistsUseCase;
import dev.raphael.library.library.core.usecases.booksUseCases.SearchBookByIdUseCase;
import dev.raphael.library.library.core.usecases.booksUseCases.SearchBookUseCase;
import dev.raphael.library.library.infra.dtos.BookDtoResponse;
import dev.raphael.library.library.infra.dtos.BooksDtoRequest;
import dev.raphael.library.library.infra.exceptions.BusinessException;
import dev.raphael.library.library.infra.mappers.BooksDomainMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/books")
public class BooksController {

    private final AddBookUseCase addBookUseCase;
    private final SearchBookUseCase searchBookUseCase;
    private final BooksDomainMapper booksDomainMapper;
    private final SearchBookByIdUseCase searchBookByIdUseCase;
    private final CheckIfIsbnAlreadyExistsUseCase checkIfIsbnAlreadyExistsUseCase;

    public BooksController(AddBookUseCase addBookUseCase, BooksDomainMapper booksDomainMapper, SearchBookUseCase searchBookUseCase, SearchBookByIdUseCase searchBookByIdUseCase, CheckIfIsbnAlreadyExistsUseCase checkIfIsbnAlreadyExistsUseCase) {
        this.addBookUseCase = addBookUseCase;
        this.booksDomainMapper = booksDomainMapper;
        this.searchBookUseCase = searchBookUseCase;
        this.searchBookByIdUseCase = searchBookByIdUseCase;
        this.checkIfIsbnAlreadyExistsUseCase = checkIfIsbnAlreadyExistsUseCase;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createBook(@RequestBody BooksDtoRequest book) {
        checkIfIsbnAlreadyExistsUseCase.execute(book.isbn()).ifPresent(status -> {
            throw new BusinessException("ISBN already exists");
        });
        Books newBook = addBookUseCase.execute(booksDomainMapper.toDomain(book));
        Map<String, Object> response = new HashMap<>();
        response.put("Book:", booksDomainMapper.toBookDtoResponse(newBook));
        response.put("Message:", "Book added successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public List<BookDtoResponse> searchBooks() {
        List<Books> booksList = searchBookUseCase.execute();
        return booksList.stream()
                .map(booksDomainMapper::toBookDtoResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public Optional<BookDtoResponse> searchBookById(@PathVariable Long id) {
        Optional<Books> book = searchBookByIdUseCase.execute(id);
        return book.map(booksDomainMapper::toBookDtoResponse);
    }

}
