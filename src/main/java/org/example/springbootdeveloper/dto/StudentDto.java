package org.example.springbootdeveloper.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor  // 기본 생성자
@AllArgsConstructor // 모든 필드를 초기화하는 생성자
@Getter
@Setter
public class StudentDto {
    private Long id;
    private String name;
    private String email;
}
