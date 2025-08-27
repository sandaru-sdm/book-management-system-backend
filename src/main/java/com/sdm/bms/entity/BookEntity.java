package com.sdm.bms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "book")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = "deleted_at is null")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    @Column(unique = true)
    private String isbn;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate publicationDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate deletedAt;
}
