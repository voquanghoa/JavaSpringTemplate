package com.quanghoa.springtemplate.domain.book;

import com.quanghoa.springtemplate.persistence.book.BookStore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.quanghoa.springtemplate.fakes.BookFakes.buildBooks;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
}