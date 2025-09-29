package com.sdm.bms.repository;

import com.sdm.bms.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
    Boolean existsByIsbn(String isbn);

//    @Query("SELECT b FROM BookEntity b WHERE b.publicationDate >= :fromDate AND b.publicationDate <= :toDate")
//    List<BookEntity> findPublicationDateBetween(@Param("fromDate") LocalDate fromDate, @Param("toDate") LocalDate toDate);

//    @Query("SELECT b FROM BookEntity b WHERE b.publicationDate BETWEEN :fromDate AND :toDate")
//    List<BookEntity> findPublicationDateBetween(@Param("fromDate") LocalDate fromDate, @Param("toDate") LocalDate toDate);

    List<BookEntity> findByPublicationDateBetween(LocalDate fromDate, LocalDate toDate);

    @Query("SELECT b FROM BookEntity b WHERE b.deletedAt IS NULL")
    List<BookEntity> findAllActiveBooks();

}
