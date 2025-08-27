package com.sdm.bms.controller;

import com.sdm.bms.dto.BookRequestDto;
import com.sdm.bms.dto.BookResponseDto;
import com.sdm.bms.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/books")
    public ResponseEntity<BookResponseDto> save(@Valid @RequestBody BookRequestDto requestDto) {
        BookResponseDto bookDto = bookService.createBook(requestDto);
        return ResponseEntity.ok(bookDto);
    }

    @GetMapping("/books")
    public ResponseEntity<List<BookResponseDto>> getAllBooks() {
        List<BookResponseDto> books = bookService.getAllBooks();
        return ResponseEntity.ok().body(books);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<BookResponseDto> getBookById(@PathVariable Long id) {
        BookResponseDto book = bookService.getBookById(id);
        return ResponseEntity.ok().body(book);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<BookResponseDto> updateBook(@PathVariable Long id, @Valid @RequestBody BookRequestDto requestDto) {
        BookResponseDto updatedBook = bookService.updateBook(id, requestDto);
        return ResponseEntity.ok().body(updatedBook);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok().body("Book deleted Successfully");
    }

//    http://localhost:8080/api/v1/books?fromDate=2025-05-21&toDate=2025-08-23

//    @GetMapping
//    public ResponseEntity<List<BookResponseDto>> getBookByPublishedDate(@RequestParam LocalDate fromDate, @RequestParam LocalDate toDate) {
//        List<BookResponseDto> books = bookService.getBooksByPublishedDate(fromDate,toDate);
//    }
}
