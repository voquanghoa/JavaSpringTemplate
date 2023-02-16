package com.quanghoa.springtemplate.domain.book;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class Book {

    private UUID id;
    private String name;
}
