package org.example.springbootdeveloper.repository;

import org.example.springbootdeveloper.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    // 반환타입 메서드명(매개변수...);
    // : 구현부가 없는 메서드

    // 작성자를 사용하여 게시글 조회 - 필터링
    List<Post> findByAuthor(String author);
}
