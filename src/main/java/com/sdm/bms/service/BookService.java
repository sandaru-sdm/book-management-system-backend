package com.sdm.bms.service;

import com.sdm.bms.dto.BookRequestDto;
import com.sdm.bms.dto.BookResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {
    BookResponseDto createBook(BookRequestDto request);

    List<BookResponseDto> getAllBooks();

    BookResponseDto getBookById(Long id);

    BookResponseDto updateBook(Long id, BookRequestDto requestDto);

    void deleteBook(Long id);
}
