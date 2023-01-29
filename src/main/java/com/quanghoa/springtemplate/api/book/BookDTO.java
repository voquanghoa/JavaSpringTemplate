package com.quanghoa.springtemplate.api.book;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BookDTO {
    private String id;
    private String name;
}
