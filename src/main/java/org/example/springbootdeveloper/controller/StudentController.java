package org.example.springbootdeveloper.controller;

import org.example.springbootdeveloper.dto.StudentDto;
import org.example.springbootdeveloper.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RestController
// : @Controller + @ResponseBody가 결합된 애너테이션
// : RESTful 웹 서비스의 컨트롤러임을 명시
@RestController
// @REquestMapping("경로")
// : 해당 컨트롤러의 모든 요청 URL이 "/api/students"로 시작함을 정의
@RequestMapping("/api/students")
public class StudentController {

    // 비즈니스 로직을 처리하는 Service 객체를 주입받아 사용
    private final StudentService studentService;

    // 생성자 주입 (DI)
    // : 외부에서 StudentService 객체를 주입받아 초기화
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // 1) 학생 목록 조회 (GET) - 모든 학생 목록 반환
    @GetMapping // HTTP GET 요청을 처리 "/api/students" 경로에 매핑
    public List<StudentDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    // 2) ID로 학생 조회 (GET) - 특정 ID의 학생 정보 반환

    // "api/students/{id}" 경로로 오는 GET 요청을 처리
    // : {id}는 경로 변수로 사용
    @GetMapping("/{id}")
    public StudentDto getStudentById(@PathVariable Long id) {
        // @PathVariable: URL 경로에 전달된 id값을 메서드 파라미터로 매핑
        return studentService.getStudentById(id);
    }

    // 3) 학생 등록 (POST) - 새로운 학생 데이터 등록

    // HTTP POST 요청을 처리, "api/students" 경로와 매핑
    @PostMapping
    public StudentDto createStudent(@RequestBody StudentDto studentDto) {
        // @RequestBody
        // : 클라이언트에서 전달된 JSON 데이터를 StudentDto 객체로 변환
        return studentService.createStudent(studentDto);
    }

    // 4. 학생 정보 수정 (PUT) - 특정 ID의 학생 정보를 수정
    @PutMapping("/{id}")
    public StudentDto updateStudent(@PathVariable Long id, @RequestBody StudentDto studentDto) {
        return studentService.updateStudent(id, studentDto);
    }

    // 5) 학생 정보 삭제 (DELETE) - 특정 ID의 학생 정보를 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
        // : HTTP 상태 코드의 204 No Content를 반환 : 본문 없이 응답을 완료시킴
    }
}

