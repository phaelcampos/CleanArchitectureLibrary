package dev.raphael.library.library.infra.persistence;

import dev.raphael.library.library.core.enums.Genres;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "books")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    private String isbn;

    private String publisher;

    private LocalDate publishedDate;

    private String description;

    @Enumerated(EnumType.STRING)
    private Genres genre;

    private String language;

    private int quantityAvailable;

    private int quantityTotal;
}
