package dev.raphael.library.library.infra.beans;

import dev.raphael.library.library.core.gateway.BooksGateway;
import dev.raphael.library.library.core.usecases.AddBookCase;
import dev.raphael.library.library.core.usecases.AddBookCaseImpl;
import dev.raphael.library.library.core.usecases.SearchBookCase;
import dev.raphael.library.library.core.usecases.SearchBookCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class BeanConfiguration {

    @Bean
    public AddBookCase addBook(BooksGateway booksGateway){
        return new AddBookCaseImpl(booksGateway);
    }

    @Bean
    public SearchBookCase searchBook(BooksGateway booksGateway){
        return new SearchBookCaseImpl(booksGateway);
    }
}
