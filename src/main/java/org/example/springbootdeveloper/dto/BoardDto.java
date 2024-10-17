package org.example.springbootdeveloper.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.springbootdeveloper.repository.Category;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BoardDto {
    private Long id;
    private String writer;
    private String title;
    private String content;
    private Category category;
}
