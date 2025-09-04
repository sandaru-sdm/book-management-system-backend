package com.sdm.bms.controller;

import com.sdm.bms.dto.BookRequestDto;
import com.sdm.bms.dto.BookResponseDto;
import com.sdm.bms.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<BookResponseDto> save(@Valid @RequestBody BookRequestDto requestDto) {
        BookResponseDto bookDto = bookService.createBook(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookDto);
    }

    @GetMapping
    public ResponseEntity<List<BookResponseDto>> getAllBooks() {
        List<BookResponseDto> books = bookService.getAllBooks();
        return ResponseEntity.ok().body(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDto> getBookById(@PathVariable Long id) {
        BookResponseDto book = bookService.getBookById(id);
        return ResponseEntity.ok().body(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponseDto> updateBook(@PathVariable Long id, @Valid @RequestBody BookRequestDto requestDto) {
        BookResponseDto updatedBook = bookService.updateBook(id, requestDto);
        return ResponseEntity.ok().body(updatedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok().body("Book deleted Successfully");
    }

    @GetMapping("/by-date")
    public ResponseEntity<List<BookResponseDto>> getBookByPublishedDate(@RequestParam LocalDate fromDate, @RequestParam LocalDate toDate) {
        List<BookResponseDto> books = bookService.getBooksByPublishedDate(fromDate,toDate);
        return ResponseEntity.ok().body(books);
    }
}
