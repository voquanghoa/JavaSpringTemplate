package com.quanghoa.springtemplate.persistence.book;


import com.quanghoa.springtemplate.domain.book.Book;
import lombok.experimental.UtilityClass;

import java.util.List;

import static org.apache.commons.collections4.ListUtils.emptyIfNull;

@UtilityClass
public class BookEntityMapper {

    public static Book toBook(final BookEntity bookEntity) {
        return Book.builder()
                .id(bookEntity.getId())
                .name(bookEntity.getName())
                .build();
    }

    public static List<Book> toBooks(final List<BookEntity> bookEntities) {
        return emptyIfNull(bookEntities)
                .stream()
                .map(BookEntityMapper::toBook)
                .toList();
    }
}
