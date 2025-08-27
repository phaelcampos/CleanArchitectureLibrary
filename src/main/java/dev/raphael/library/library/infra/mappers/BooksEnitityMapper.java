package dev.raphael.library.library.infra.mappers;

import dev.raphael.library.library.core.entities.Books;
import dev.raphael.library.library.infra.persistence.BookEntity;
import org.springframework.stereotype.Component;

@Component
public class BooksEnitityMapper {

    public BookEntity toEntity(Books domain){
        return new BookEntity(
                domain.id(),
                domain.title(),
                domain.author(),
                domain.isbn(),
                domain.publisher(),
                domain.publishedDate(),
                domain.description(),
                domain.genre(),
                domain.language(),
                domain.quantityAvailable(),
                domain.quantityTotal()
        );
    }

    public Books toDomain(BookEntity entity){
        return new Books(
                entity.getId(),
                entity.getTitle(),
                entity.getTitle(),
                entity.getIsbn(),
                entity.getPublisher(),
                entity.getPublishedDate(),
                entity.getDescription(),
                entity.getGenre(),
                entity.getLanguage(),
                entity.getQuantityAvailable(),
                entity.getQuantityTotal()
        );
    }
}
