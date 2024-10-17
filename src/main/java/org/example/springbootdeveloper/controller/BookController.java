package org.example.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import org.example.springbootdeveloper.dto.request.BookRequestDto;
import org.example.springbootdeveloper.dto.request.BookRequestUpdateDto;
import org.example.springbootdeveloper.dto.response.BookResponseDto;
import org.example.springbootdeveloper.repository.Category;
import org.example.springbootdeveloper.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
// 초기화 되지 않은 final 필드나 @NonNull이 붙은 필드에 대해 생성자를 생성
public class BookController {
    // Service 객체를 주입 받아 사용하는 변수
    private final BookService bookService;

    // 생성자 주입 - RequiredArgsConstructor로 대체
//    public BookController(BookService bookService) {
//        this.bookService = bookService;
//    }

    // 책 생성
    @PostMapping
    public ResponseEntity<BookResponseDto> createBook(@RequestBody BookRequestDto requestDto) {
        BookResponseDto createdBook = bookService.createBook(requestDto);
        return ResponseEntity.ok(createdBook);
    }

    // 전체 책 조회
    @GetMapping
    public ResponseEntity<List<BookResponseDto>> getAllBooks() {
        List<BookResponseDto> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    // 제목에 특정 단어가 포함된 책 조회
    @GetMapping("/search/title")
    public ResponseEntity<List<BookResponseDto>> getBookByTitleContaining(
            @RequestParam String keyword
    ) {
        List<BookResponseDto> books = bookService.getBooksByTitleContaining(keyword);
        return ResponseEntity.ok(books);
    }

    // 카테고리별 책 조회
    @GetMapping("/category/{category}")
    public ResponseEntity<List<BookResponseDto>> getBooksByCategory(@PathVariable Category category) {
        List<BookResponseDto> books = bookService.getBooksByCategory(category);
        return ResponseEntity.ok(books);
    }

    // 단건 책 조회
    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDto> getBookById(@PathVariable Long id) {
        BookResponseDto book = bookService.getBookById(id);
        return ResponseEntity.ok(book);
    }

    // 특정 id 책 수정
    @PutMapping("/{id}")
    public ResponseEntity<BookResponseDto> updateBook(
            @PathVariable Long id, @RequestBody BookRequestUpdateDto requestDto) {
        BookResponseDto updatedBook = bookService.updateBook(id, requestDto);
        return ResponseEntity.ok(updatedBook);
    }

    // 특정 id 책 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
