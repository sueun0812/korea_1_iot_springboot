package org.example.springbootdeveloper.dto.request;

import lombok.Data;

@Data
public class PostRequestDto {
    private String title;
    private String content;
    private String author;
}
