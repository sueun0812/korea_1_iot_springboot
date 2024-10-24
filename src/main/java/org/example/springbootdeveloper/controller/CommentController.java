package org.example.springbootdeveloper.controller;

import org.example.springbootdeveloper.dto.request.CommentRequestDto;
import org.example.springbootdeveloper.dto.response.CommentResponseDto;
import org.example.springbootdeveloper.dto.response.ResponseDto;
import org.example.springbootdeveloper.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    // 의존성 주입(DI)
    // - 필드 주입, 메서드 주입, 생성자 주입

    // @Autowired
    // : 필드 주입 방식 - 스프링이 필드 자체에 객체를 주입

    // @RequiredArgsConstructor
    // : 생성자 주입 방식* - 롬복 애너테이션
    // : final과 @NonNull 필드에 대해 자동으로 생성자를 생성

    @Autowired
    private CommentService commentService;

    @PostMapping
    public ResponseDto<CommentResponseDto> createComment(@RequestBody CommentRequestDto dto) {
        return commentService.createComment(dto);
    }

    @GetMapping("/post/{postId}")
    public ResponseDto<List<CommentResponseDto>> getCommentsByPost(@PathVariable Long postId) {
        return commentService.getCommentsByPost(postId);
    }

    @PutMapping("/{commentId}")
    public ResponseDto<CommentResponseDto> updateComment(
            @PathVariable Long commentId,
            @RequestBody CommentRequestDto dto
    ) {
        return commentService.updateComment(commentId, dto);
    }

    @DeleteMapping("/{commentId}")
    public ResponseDto<Void> deleteComment(
            @PathVariable Long commentId
    ) {
        return commentService.deleteComment(commentId);
    }




}
