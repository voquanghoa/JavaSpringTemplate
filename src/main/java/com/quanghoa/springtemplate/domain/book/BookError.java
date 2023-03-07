package com.quanghoa.springtemplate.domain.book;

import com.quanghoa.springtemplate.error.NotFoundException;
import lombok.experimental.UtilityClass;

import java.util.UUID;
import java.util.function.Supplier;

@UtilityClass
public class BookError {

    public static Supplier<NotFoundException> supplyBookNotFound(final UUID id) {
        return () -> new NotFoundException("Book with id %s could not be found", id);
    }
}
