package com.quanghoa.springtemplate.domain.book;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Book {
    private String id;
    private String name;
}
