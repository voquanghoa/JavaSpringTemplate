package com.quanghoa.springtemplate.domain.book;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class BookServiceTest {

    @Test
    void shouldFindAll_OK() {

        assertNotNull(new BookService().findAll());
    }
}