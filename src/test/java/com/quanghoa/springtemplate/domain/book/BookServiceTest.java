package com.quanghoa.springtemplate.domain.book;

import com.quanghoa.springtemplate.error.NotFoundException;
import com.quanghoa.springtemplate.persistence.book.BookStore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.quanghoa.springtemplate.fakes.BookFakes.buildBook;
import static com.quanghoa.springtemplate.fakes.BookFakes.buildBooks;
import static java.util.UUID.randomUUID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookStore bookStore;


    @InjectMocks
    private BookService bookService;

    @Test
    void shouldFindAll_OK() {

        final var expected = buildBooks();

        when(bookStore.findAll())
                .thenReturn(expected);

        final var actual = bookService.findAll();

        assertEquals(expected.size(), actual.size());
        assertEquals(expected.get(0).getId(), actual.get(0).getId());
        assertEquals(expected.get(0).getName(), actual.get(0).getName());

        verify(bookStore).findAll();
    }

    @Test
    void shouldFindById_OK() {
        final var expected = buildBook();
        when(bookStore.findById(expected.getId()))
                .thenReturn(Optional.of(expected));

        assertEquals(expected, bookService.findById(expected.getId()));
        verify(bookStore).findById(expected.getId());
    }

    @Test
    void shouldFindById_Throw() {
        final var id = randomUUID();
        when(bookStore.findById(id))
                .thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> bookService.findById(id));
        verify(bookStore).findById(id);
    }
}