package com.quanghoa.springtemplate.api.book;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class BookDTO {

    private UUID id;
    private String name;
}
