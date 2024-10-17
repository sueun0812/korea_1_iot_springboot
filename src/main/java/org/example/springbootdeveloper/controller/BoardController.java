package org.example.springbootdeveloper.controller;

import org.example.springbootdeveloper.dto.BoardDto;
import org.example.springbootdeveloper.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boards")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping
    public List<BoardDto> getAllBoards() {
        return boardService.getAllBoards();
    }

    @GetMapping("/{id}")
    public BoardDto getBoardById(@PathVariable Long id) {
        return boardService.getBoardById(id);
    }

    @PostMapping
    public BoardDto createBoard(@RequestBody BoardDto boardDto) {
        return boardService.createBoard(boardDto);
    }

    @PutMapping("/{id}")
    public BoardDto updateBoard(@PathVariable Long id, @RequestBody BoardDto boardDto) {
        return boardService.updateBoard(id, boardDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable Long id) {
        boardService.deleteBoard(id);
        return ResponseEntity.noContent().build();
    }
}
