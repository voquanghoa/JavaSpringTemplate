package com.quanghoa.springtemplate.persistence.book;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface BookRepository extends CrudRepository<BookEntity, UUID> {

}
