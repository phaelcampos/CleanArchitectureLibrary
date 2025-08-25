package dev.raphael.library.library.core.entities;

import dev.raphael.library.library.core.enums.Genres;

import java.time.LocalDate;

public record Books(
        String id,

        String title,

        String author,

        String isbn,

        String publisher,

        LocalDate publishedDate,

        String description,

        Genres genre,

        String language,

        int quantityAvailable,

        int quantityTotal) {}
