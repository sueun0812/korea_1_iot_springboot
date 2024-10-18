package org.example.springbootdeveloper.service;

import org.example.springbootdeveloper.dto.request.CommentRequestDto;
import org.example.springbootdeveloper.dto.response.CommentResponseDto;
import org.example.springbootdeveloper.dto.response.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    public ResponseDto<CommentResponseDto> createComment(CommentRequestDto dto) {
        return null;
    }

    public ResponseDto<List<CommentResponseDto>> getCommentsByPost(Long postId) {
        return null;
    }

    public ResponseDto<CommentResponseDto> updateComment(Long commentId, String newContent) {
        return null;
    }

    public ResponseDto<Void> deleteComment(Long commentId) {
        return null;
    }
}
