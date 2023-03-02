package com.quanghoa.springtemplate.domain.book;


import com.quanghoa.springtemplate.persistence.book.BookStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.quanghoa.springtemplate.domain.book.BookError.supplyBookNotFound;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookStore bookStore;

    public List<Book> findAll() {
        return bookStore.findAll();
    }

    public Book findById(final UUID id) {
        return bookStore.findById(id)
                .orElseThrow(supplyBookNotFound(id));
    }
}
