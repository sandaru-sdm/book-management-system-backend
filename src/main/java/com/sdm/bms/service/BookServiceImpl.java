package com.sdm.bms.service;

import com.sdm.bms.dto.BookRequestDto;
import com.sdm.bms.dto.BookResponseDto;
import com.sdm.bms.entity.BookEntity;
import com.sdm.bms.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    @Override
    public BookResponseDto createBook(BookRequestDto request) {
        if(bookRepository.existsByIsbn(request.getIsbn())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Isbn already exists");
        }

        if(request.getTitle().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Title is empty");
        }

        BookEntity newBook = convertToBookEntity(request);
        newBook = bookRepository.save(newBook);
        return convertToBookResponse(newBook);
    }

    @Override
    public List<BookResponseDto> getAllBooks() {
        List<BookEntity> books = bookRepository.findAll();

        return books.stream().map(this::convertToBookResponse).collect(Collectors.toList());
    }

    @Override
    public List<BookResponseDto> getBooksByPublishedDate(LocalDate fromDate, LocalDate toDate) {
        List<BookEntity> books = bookRepository.findByPublicationDateBetween(fromDate, toDate);
        return books.stream().map(this::convertToBookResponse).collect(Collectors.toList());
    }

    @Override
    public BookResponseDto getBookById(Long id) {
        BookEntity book = bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Book not found for id : " + id));
        return convertToBookResponse(book);
    }

    @Override
    public BookResponseDto updateBook(Long id, BookRequestDto requestDto) {
        BookEntity existBook = bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Book not found for ID : " + id));

        if (!existBook.getIsbn().equals(requestDto.getIsbn())) {
            if (bookRepository.existsByIsbn(requestDto.getIsbn())) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Isbn already exists for another book");
            }
        }

        existBook.setAuthor(requestDto.getAuthor());
        existBook.setIsbn(requestDto.getIsbn());
        existBook.setTitle(requestDto.getTitle());
        existBook.setPublicationDate(requestDto.getPublicationDate());

        BookEntity updatedBook = bookRepository.save(existBook);
        return convertToBookResponse(updatedBook);
    }

    @Override
    public void deleteBook(Long id) {
        BookEntity existBook = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book not found for ID: " + id));

        if (existBook.getDeletedAt() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Book with ID: " + id + " is already deleted");
        }

        existBook.setDeletedAt(LocalDate.now());

        bookRepository.save(existBook);
    }

    private BookResponseDto convertToBookResponse(BookEntity newBook) {
        return BookResponseDto.builder()
                .id(newBook.getId())
                .title(newBook.getTitle())
                .author(newBook.getAuthor())
                .isbn(newBook.getIsbn())
                .publicationDate(newBook.getPublicationDate())
                .build();
    }

    private BookEntity convertToBookEntity(BookRequestDto request) {
        return BookEntity.builder()
                .title(request.getTitle())
                .author(request.getAuthor())
                .isbn(request.getIsbn())
                .publicationDate(request.getPublicationDate())
                .build();
    }
}
