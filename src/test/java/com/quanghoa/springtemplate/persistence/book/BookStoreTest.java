package com.quanghoa.springtemplate.persistence.book;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.quanghoa.springtemplate.fakes.BookFakes.buildBookEntities;
import static com.quanghoa.springtemplate.fakes.BookFakes.buildBookEntity;
import static java.util.UUID.randomUUID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class BookStoreTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookStore bookStore;

    @Test
    void shouldFindAll_OK() {
        final var expected = buildBookEntities();

        when(bookRepository.findAll())
                .thenReturn(expected);

        assertEquals(expected.size(), bookStore.findAll().size());

        verify(bookRepository).findAll();
    }

    @Test
    void shouldFindById_OK() {
        final var book = buildBookEntity();
        final var bookOpt = Optional.of(book);
        when(bookRepository.findById(book.getId()))
                .thenReturn(bookOpt);

        assertEquals(bookOpt, bookRepository.findById(book.getId()));
        verify(bookRepository).findById(book.getId());
    }

    @Test
    void shouldFindById_Empty() {
        final var id = randomUUID();
        final Optional<BookEntity> bookOpt = Optional.empty();
        when(bookRepository.findById(id))
                .thenReturn(bookOpt);

        assertFalse(bookRepository.findById(id).isPresent());
        verify(bookRepository).findById(id);
    }
}