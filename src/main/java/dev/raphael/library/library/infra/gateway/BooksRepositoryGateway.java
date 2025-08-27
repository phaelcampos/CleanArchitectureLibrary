package dev.raphael.library.library.infra.gateway;

import dev.raphael.library.library.core.entities.Books;
import dev.raphael.library.library.core.gateway.BooksGateway;
import dev.raphael.library.library.infra.mappers.BooksEnitityMapper;
import dev.raphael.library.library.infra.mappers.BooksMapper;
import dev.raphael.library.library.infra.persistence.BookEntity;
import dev.raphael.library.library.infra.persistence.BookRepository;
import org.springframework.stereotype.Component;

import java.awt.print.Book;
import java.util.List;

@Component
public class BooksRepositoryGateway implements BooksGateway {

    private final BookRepository bookRepository;
    private final BooksEnitityMapper booksEnitityMapper;

    public BooksRepositoryGateway(BookRepository bookRepository, BooksEnitityMapper booksEnitityMapper) {
        this.bookRepository = bookRepository;
        this.booksEnitityMapper = booksEnitityMapper;
    }

    @Override
    public Books addBook(Books book) {
        BookEntity bookEntity = bookRepository.save(booksEnitityMapper.toEntity(book));
        return booksEnitityMapper.toDomain(bookEntity) ;
    }

    @Override
    public List<Books> getBooks() {
        List<BookEntity> bookEntities = bookRepository.findAll();
        return bookEntities.stream()
                .map(booksEnitityMapper::toDomain)
                .toList();
    }


}
