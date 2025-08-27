package com.sdm.bms.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class BookRequestDto {
    @NotNull(message = "Title should not be empty")
    private String title;
    @NotNull(message = "Author should not be empty")
    private String author;
    @NotNull(message = "Isbn should not be empty")
    private String isbn;
    private LocalDate publicationDate;
}
