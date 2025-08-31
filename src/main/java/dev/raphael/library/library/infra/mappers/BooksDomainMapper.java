package dev.raphael.library.library.infra.mappers;

import dev.raphael.library.library.core.entities.Books;
import dev.raphael.library.library.infra.dtos.BookDtoResponse;
import dev.raphael.library.library.infra.dtos.BooksDtoRequest;
import org.springframework.stereotype.Component;

@Component
public class BooksDomainMapper {

    public Books toDomain(BooksDtoRequest booksDto) {
            return new Books(
                    booksDto.id(),
                    booksDto.title(),
                    booksDto.author(),
                    booksDto.isbn(),
                    booksDto.publisher(),
                    booksDto.publishedDate(),
                    booksDto.description(),
                    booksDto.genre(),
                    booksDto.language(),
                    booksDto.quantityAvailable(),
                    booksDto.quantityTotal()
            );
    }

    public BookDtoResponse toBookDtoResponse(Books books) {
        return new BookDtoResponse(
                books.id(),
                books.title(),
                books.author(),
                books.isbn(),
                books.publisher(),
                books.publishedDate(),
                books.description(),
                books.genre(),
                books.language(),
                books.quantityAvailable(),
                books.quantityTotal()
                );
    }
}
