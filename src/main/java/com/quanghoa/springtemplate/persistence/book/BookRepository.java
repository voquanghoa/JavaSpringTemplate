package com.quanghoa.springtemplate.persistence.book;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, UUID> {

}
