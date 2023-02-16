package com.quanghoa.springtemplate.persistence.book;

import org.junit.jupiter.api.Test;

import static com.quanghoa.springtemplate.fakes.BookFakes.buildBookEntities;
import static com.quanghoa.springtemplate.fakes.BookFakes.buildBookEntity;
import static com.quanghoa.springtemplate.persistence.book.BookEntityMapper.toBook;
import static com.quanghoa.springtemplate.persistence.book.BookEntityMapper.toBooks;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BookEntityMapperTest {

    @Test
    void shouldToBook_OK() {
        final var bookEntity = buildBookEntity();
        final var book = toBook(bookEntity);

        assertEquals(bookEntity.getId(), book.getId());
        assertEquals(bookEntity.getName(), book.getName());
    }

    @Test
    void shouldToBooks_OK() {
        final var bookEntities = buildBookEntities();
        final var book = toBooks(bookEntities);

        assertEquals(bookEntities.size(), book.size());
    }
}