package com.quanghoa.springtemplate.api.book;

import org.junit.jupiter.api.Test;

import static com.quanghoa.springtemplate.api.book.BookDTOMapper.toBookDTO;
import static com.quanghoa.springtemplate.api.book.BookDTOMapper.toBookDTOs;
import static com.quanghoa.springtemplate.fakes.BookFakes.buildBook;
import static com.quanghoa.springtemplate.fakes.BookFakes.buildBooks;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BookDTOMapperTest {

    @Test
    void shouldToBookDTO_OK() {
        final var book = buildBook();
        final var bookDTO = toBookDTO(book);

        assertEquals(book.getId(), bookDTO.getId());
        assertEquals(book.getName(), bookDTO.getName());
    }

    @Test
    void shouldToBookDTOs_OK() {
        final var books = buildBooks();

        final var bookDTOs = toBookDTOs(books);
        assertEquals(books.size(), bookDTOs.size());
    }
}