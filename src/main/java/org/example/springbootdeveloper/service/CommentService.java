package org.example.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import org.example.springbootdeveloper.dto.request.CommentRequestDto;
import org.example.springbootdeveloper.dto.response.CommentResponseDto;
import org.example.springbootdeveloper.dto.response.ResponseDto;
import org.example.springbootdeveloper.entity.Comment;
import org.example.springbootdeveloper.entity.Post;
import org.example.springbootdeveloper.repository.CommentRepository;
import org.example.springbootdeveloper.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {
//    @Autowired - final 없애고 의존성 주입하는 애너테이션
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    // 새로운 댓글 등록
    public ResponseDto<CommentResponseDto> createComment(CommentRequestDto dto) {
        Post postId = postRepository.findById(dto.getPostId())
                .orElseThrow(() -> new Error("게시글이 없습니다."));
        try {
            Comment comment = Comment.builder()
                    .post(postId)
                    .content(dto.getContent())
                    .commenter(dto.getCommenter())
                    .build();
            commentRepository.save(comment);
            return ResponseDto.setSuccess("댓글 등록 성공", convertToCommentResponseDto(comment));

        } catch (Exception e) {
            return ResponseDto.setFailed("댓글 등록 실패" + e.getMessage());
        }
    }

    // 게시글별 댓글 조회
    public ResponseDto<List<CommentResponseDto>> getCommentsByPost(Long postId) {
        try {
            List<CommentResponseDto> commentResponseDtos = commentRepository.findByPostId(postId)
                    .stream()
                    .map(this::convertToCommentResponseDto)
                    .collect(Collectors.toList());
            return ResponseDto.setSuccess("댓글 조회 성공", commentResponseDtos);
        } catch (Exception e) {
            return ResponseDto.setFailed("댓글 조회 실패" + e.getMessage());
        }
    }

    // 댓글 수정
    public ResponseDto<CommentResponseDto> updateComment(Long commentId, CommentRequestDto dto) {
        try {
            Comment comment = commentRepository.findById(commentId)
                    .orElseThrow(() -> new IllegalArgumentException("댓글을 찾을 수 없습니다." + commentId));

            comment.setContent(dto.getContent());

            Comment updateComment = commentRepository.save(comment);

            return ResponseDto.setSuccess("댓글 수정 성공", convertToCommentResponseDto(updateComment));

        } catch (Exception e) {
            return ResponseDto.setFailed("댓글 수정 실패" + e.getMessage());
        }
    }

    // 댓글 삭제
    public ResponseDto<Void> deleteComment(Long commentId) {
        try {
            commentRepository.deleteById(commentId);
            return ResponseDto.setSuccess("댓글 삭제 성공", null);
        } catch (Exception e) {
            return ResponseDto.setFailed("댓글 삭제 실패");
        }
    }

    private CommentResponseDto convertToCommentResponseDto(Comment comment) {
        return new CommentResponseDto(
                comment.getId(), comment.getPost().getId(), comment.getContent()
                , comment.getCommenter()
        );
    }
}
