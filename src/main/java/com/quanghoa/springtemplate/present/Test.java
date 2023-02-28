package com.quanghoa.springtemplate.present;

import java.util.List;

class Book {}

class Author {}

interface DataBase {

    <T> List<T> query();

    void closeConnection();
}

class MySQL implements DataBase {

    public <T> List<T> query() {
        return null;
    }

    public void closeConnection() {

    }
}

class Postgres implements DataBase {

    public <T> List<T> query() {
        return null;
    }

    public void closeConnection() {

    }
}

class MySQLEx extends MySQL {

}

class BookService {

    private final DataBase dataBase;

    public BookService(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public void queryBooks() {
        final List<Book> books = dataBase.query();
        // do something
    }
}

class AuthorService {

    private final DataBase dataBase;

    public AuthorService(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public void queryAuthors() {
        final List<Author> author = dataBase.query();
        // do something
    }
}

public class Test {

    public static void main(String[] args) {
        final var mysql = new MySQL();

        final var bookService = new BookService(mysql);

        final var authorService = new AuthorService(mysql);


        final var bookServiceEx = new BookService(new MySQLEx());
        final var bookServicePostgress = new BookService(new Postgres());

        bookService.queryBooks();
        authorService.queryAuthors();

        mysql.closeConnection();
    }
}
