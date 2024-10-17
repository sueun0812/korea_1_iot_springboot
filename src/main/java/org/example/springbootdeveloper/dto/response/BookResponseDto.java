package org.example.springbootdeveloper.dto.response;

import lombok.*;
import org.example.springbootdeveloper.repository.Category;

// 서버가 클라이언트에 응답할 때 필요한 데이터만 전달
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookResponseDto {
    private Long id;
    private String writer;
    private String title;
    private String content;
    private Category category;
}
