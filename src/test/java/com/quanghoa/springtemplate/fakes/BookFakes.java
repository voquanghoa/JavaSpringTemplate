package com.quanghoa.springtemplate.fakes;


import com.quanghoa.springtemplate.domain.book.Book;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

@UtilityClass
public class BookFakes {

    public static Book buildBook() {
        return Book.builder()
                .id(UUID.randomUUID().toString())
                .name(RandomStringUtils.randomAlphabetic(3, 10))
                .build();
    }

    public static List<Book> buildBooks() {
        return IntStream.range(1, 5)
                .mapToObj(_ignored -> buildBook())
                .toList();
    }
}
