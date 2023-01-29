package com.quanghoa.springtemplate.domain.book;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    public List<Book> findAll() {
        return List.of(
                Book.builder().id("1").name("Book One").build(),
                Book.builder().id("2").name("Book Two").build(),
                Book.builder().id("3").name("Book Three").build()
        );
    }
}
