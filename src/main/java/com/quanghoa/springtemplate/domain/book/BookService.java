package com.quanghoa.springtemplate.domain.book;


import com.quanghoa.springtemplate.error.NotFoundException;
import com.quanghoa.springtemplate.persistence.book.BookStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookStore bookStore;

    public List<Book> findAll() {
        return bookStore.findAll();
    }

    public Book findById(final UUID uuid) {
        return bookStore.findById(uuid)
                .orElseThrow(() -> new NotFoundException("Book with id %s could not be found", uuid));
    }
}
