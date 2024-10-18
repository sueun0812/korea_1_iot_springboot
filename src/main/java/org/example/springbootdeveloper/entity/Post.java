package org.example.springbootdeveloper.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private String author;

    // @OneToMany
    // : Post 엔티티와 Comment 엔티티 간의 "일대다 관계"
    // >> 한 개의 Post가 여러 개의 Comment

    // - mappedBy = "post"
    //      : Comment 엔티티 내에서 post 필드를 통해 관계가 매핑되었음을 명시

    // - cascade = CascadeType.ALL
    //      : Post 엔티티에 대한 모든 변경사항(삽입, 수정, 삭제)이 Comment 엔티티에 전파

    // - orphanRemoval = true
    //      : 고아 객체 제거
    //      : Post 객체에서 Comments 리스트의 특정 Comment 객체를 제거할 경우
    //      >> 자동으로 해당 Comment가 제거
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

}
