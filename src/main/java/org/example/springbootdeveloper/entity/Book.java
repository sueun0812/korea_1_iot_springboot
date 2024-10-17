package org.example.springbootdeveloper.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.springbootdeveloper.repository.Category;

@Entity
@Table(name = "book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String writer;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 500)
    private String content;

    @Enumerated(EnumType.STRING)
    // JPA에서 열거형 데이터를 DB에 저장할 때 방식을 지정
    // : enum의 이름을 문자열로 저장
    @Column(nullable = false, length = 100)
    private Category category;
}
