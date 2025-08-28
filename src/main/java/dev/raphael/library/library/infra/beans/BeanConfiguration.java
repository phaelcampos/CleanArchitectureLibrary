package dev.raphael.library.library.infra.beans;

import dev.raphael.library.library.core.gateway.BooksGateway;
import dev.raphael.library.library.core.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class BeanConfiguration {

    @Bean
    public AddBookUseCase addBook(BooksGateway booksGateway){
        return new AddBookUseCaseImpl(booksGateway);
    }

    @Bean
    public SearchBookUseCase searchBook(BooksGateway booksGateway){
        return new SearchBookUseCaseImpl(booksGateway);
    }

    @Bean
    public SearchBookByIdUseCase searchBookById(BooksGateway booksGateway){return new SearchBookByIdUseCaseImpl(booksGateway);}
}
