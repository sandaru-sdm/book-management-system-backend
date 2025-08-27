package com.sdm.bms.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookResponseDto {
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private LocalDate publicationDate;
}
