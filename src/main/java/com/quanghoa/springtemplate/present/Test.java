package com.quanghoa.springtemplate.present;

import java.util.List;

class Book {}

class Author {}

class MySQL {

    <T> List<T> query() {
        return null;
    }

    void closeConnection() {

    }
}

class BookService {

    private final MySQL mySQL;

    public BookService(MySQL mySQL) {
        this.mySQL = mySQL;
    }

    public void queryBooks() {
        final List<Book> books = mySQL.query();
        // do something
    }
}

class AuthorService {

    private final MySQL mySQL;

    public AuthorService(MySQL mySQL) {
        this.mySQL = mySQL;
    }

    public void queryAuthors() {
        final List<Author> author = mySQL.query();
        // do something
    }
}

public class Test {

    public static void main(String[] args) {
        final var mysql = new MySQL();

        final var bookService = new BookService(mysql);
        final var authorService = new AuthorService(mysql);

        bookService.queryBooks();
        authorService.queryAuthors();

        mysql.closeConnection();
    }
}
