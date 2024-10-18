package org.example.springbootdeveloper.repository;

import org.example.springbootdeveloper.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(Long postId);  // 특정 게시글의 댓글 모두 조회
}
