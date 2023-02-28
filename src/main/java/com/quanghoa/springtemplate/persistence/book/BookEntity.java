package com.quanghoa.springtemplate.persistence.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table(value = "books")
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {

    private UUID id;
    private String name;
}