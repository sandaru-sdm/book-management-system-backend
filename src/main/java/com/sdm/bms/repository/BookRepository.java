package com.sdm.bms.repository;

import com.sdm.bms.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
    Boolean existsByIsbn(String isbn);
}
