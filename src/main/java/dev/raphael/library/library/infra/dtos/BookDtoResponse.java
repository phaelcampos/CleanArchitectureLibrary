package dev.raphael.library.library.infra.dtos;

import dev.raphael.library.library.core.enums.Genres;

import java.time.LocalDate;


public record BookDtoResponse (

     Long id,

     String title,

     String author,

     String isbn,

     String publisher,

     LocalDate publishedDate,

     String description,

     Genres genre,

     String language,

     int quantityAvailable,

     int quantityTotal
){}
