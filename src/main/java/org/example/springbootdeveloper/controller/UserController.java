package org.example.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import org.example.springbootdeveloper.dto.request.UserLoginRequestDto;
import org.example.springbootdeveloper.dto.request.UserRequestDto;
import org.example.springbootdeveloper.dto.response.ResponseDto;
import org.example.springbootdeveloper.dto.response.UserLoginResponseDto;
import org.example.springbootdeveloper.service.UserService;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
// final, non null 설정 된 필드를 필수 매개변수로 하는 생성자를 만드는 애너테이션
@RequiredArgsConstructor
public class UserController {

    // 1. 생성자 의존성 주입 방식
    private final @Lazy UserService userService;

//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    // 2. 필드 의존성 주입 방식
//    @Autowired
//    private UserService userService;

    // HTTP 메서드: POST
    // URI 경로: /signup
    // - 회원가입 로직: username, password, email
    @PostMapping("/signup")
    public ResponseDto<String> signup(@RequestBody UserRequestDto dto) {
        try {
            String result = userService.signup(dto);
            return ResponseDto.setSuccess("Signup successful", result);
        } catch(Exception e) {
            return ResponseDto.setFailed("Signup failed" + e.getMessage());
        }
    }

    // HTTP 메서드: POST
    // URI 경로: /login
    // - 로그인 로직: username, password

    // cf) 로그인 시 HTTP 메서드 사용

    // GET VS "POST"
    // : POST 사용을 권장
    // - 로그인 과정에서 사용자 이름과 비밀번호와 같은 민감한 데이터를 서버로 전송하기 때문
    // - GET 요청을 URL에 데이터가 노출됨
    //      : 데이터 조회에 사용
    @PostMapping("/login")
    public ResponseDto<UserLoginResponseDto> login(@RequestBody UserLoginRequestDto dto) {
        try {
            UserLoginResponseDto result = userService.login(dto);
            return ResponseDto.setSuccess("Login successful", result);
        } catch(Exception e) {
            return ResponseDto.setFailed("Login failed: " + e.getMessage());
        }
    }
}