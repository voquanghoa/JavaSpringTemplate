package com.quanghoa.springtemplate.api.book;

import com.quanghoa.springtemplate.domain.book.BookService;
import com.quanghoa.springtemplate.error.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.quanghoa.springtemplate.fakes.BookFakes.buildBook;
import static com.quanghoa.springtemplate.fakes.BookFakes.buildBooks;
import static java.util.UUID.randomUUID;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(BookController.class)
@AutoConfigureMockMvc
class BookControllerTest {

    private static final String BASE_URL = "/api/v1/books";

    @Autowired
    protected MockMvc mvc;

    @MockBean
    private BookService bookService;

    @Test
    void shouldFindAll_OK() throws Exception {
        final var books = buildBooks();

        when(bookService.findAll()).thenReturn(books);

        this.mvc.perform(MockMvcRequestBuilders.get(BASE_URL))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(books.size()))
                .andExpect(jsonPath("$[0].id").value(books.get(0).getId().toString()))
                .andExpect(jsonPath("$[0].name").value(books.get(0).getName()));

        verify(bookService).findAll();
    }

    @Test
    void shouldFindById_OK() throws Exception {
        final var book = buildBook();

        when(bookService.findById(book.getId())).thenReturn(book);

        this.mvc.perform(MockMvcRequestBuilders.get(BASE_URL + "/" + book.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(book.getId().toString()))
                .andExpect(jsonPath("$.name").value(book.getName()));

        verify(bookService).findById(book.getId());
    }

    @Test
    void shouldFindById_NotFound() throws Exception {
        final var id = randomUUID();

        when(bookService.findById(id)).thenThrow(new NotFoundException("Error"));

        this.mvc.perform(MockMvcRequestBuilders.get(BASE_URL + "/" + id))
                .andExpect(status().isNotFound());

        verify(bookService).findById(id);
    }
}