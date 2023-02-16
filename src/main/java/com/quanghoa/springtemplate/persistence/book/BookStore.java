package com.quanghoa.springtemplate.persistence.book;


import com.quanghoa.springtemplate.domain.book.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.quanghoa.springtemplate.persistence.book.BookEntityMapper.toBooks;
import static org.apache.commons.collections4.IterableUtils.toList;

@Repository
@RequiredArgsConstructor
public class BookStore {

    private final BookRepository bookRepository;

    public List<Book> findAll() {
        return toBooks(toList(bookRepository.findAll()));
    }
}
