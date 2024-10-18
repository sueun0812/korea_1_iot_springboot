package org.example.springbootdeveloper.dto.request;

import lombok.Data;

@Data
public class CommentRequestDto {
    private Long postId;    // 댓글이 달릴 게시글 ID
    private String content;
    private String commenter;   // 댓글 작성자
}
