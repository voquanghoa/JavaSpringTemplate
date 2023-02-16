package com.quanghoa.springtemplate.domain.book;


import com.quanghoa.springtemplate.persistence.book.BookStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookStore bookStore;

    public List<Book> findAll() {
        return bookStore.findAll();
    }
}
