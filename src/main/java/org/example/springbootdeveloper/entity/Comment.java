package org.example.springbootdeveloper.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @ManyToOne
    // : Comment 엔티티와 Post 엔티티 간의 다대일 관계
    // : 여러 개의 Comment가 하나의 Post에 속함

    // - fetch = FetchType.LAZY
    //      : Comment 엔티티 조회 시 Post 엔티티가 즉시 로딩되지 X
    //      >> getPost() 호출 시에만 조회

    // @JoinColumn
    // : Comment 엔티티가 다대일 관계에서 외래 키를 통해 Post 엔티티와 연관됨을 명시

    // - name = "post_id"
    //      : 외래 키 컬럼의 이름을 설정
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private String commenter;
}
