package com.quanghoa.springtemplate.api.book;

import com.quanghoa.springtemplate.domain.book.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.quanghoa.springtemplate.api.book.BookDTOMapper.toBookDTOs;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public List<BookDTO> findAll() {
        return toBookDTOs(bookService.findAll());
    }
}
