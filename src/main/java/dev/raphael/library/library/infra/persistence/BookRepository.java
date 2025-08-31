package dev.raphael.library.library.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

    public Optional<BookEntity> findBookEntitiesByIsbn(String isbn);
}
