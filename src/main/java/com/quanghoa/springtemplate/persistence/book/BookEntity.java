package com.quanghoa.springtemplate.persistence.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table(value = "books")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {

    public static final String ID_FIELD = "id";

    @Id
    private UUID id;
    private String name;
}
