--V1__crate_table_books.sql

CREATE TABLE books (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    isbn VARCHAR(20) NOT NULL UNIQUE ,
    publisher VARCHAR(255) NOT NULL ,
    published_date TIMESTAMP NOT NULL,
    description TEXT,
    genre VARCHAR(50) NOT NULL,
    language VARCHAR(50) NOT NULL,
    quantity_available INT DEFAULT 0 NOT NULL,
    quantity_total INT DEFAULT 0 NOT NULL
);
