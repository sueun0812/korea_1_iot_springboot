package org.example.springbootdeveloper.controller;

import org.example.springbootdeveloper.entity.Member;
import org.example.springbootdeveloper.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    // Get /test 요청을 하면
    // : test() 메서드를 실행하여 Hello World!!! 문자열을 반환

    // @RestController: 라우터 역할을 하는 애너테이션
    // cf) 라우터
    //     : HTTP 요청과 메서드를 연결하는 장치

    // @GetMapping 어노테이션
    // : 메서드와 경로를 매핑할 때 스프링부트에서 설정한 경로
    // http://localhost(사용중인 컴퓨터):8080(포트번호)/test(경로)
//    @GetMapping("/test")
//    public String test() {
//        return "Hello World!!!";
//    }

    @Autowired
    TestService testService;

    @GetMapping("/test")
    public List<Member> getAllMembers() {
        List<Member> members = testService.getAllMembers();
        return members;
    }
}

// 스프링부트 스타터
// 1) spring-boot-starter-web
// : Spring MVC를 사용하여 RESTful 웹 서비스를 개발할 때 필요한 의존성 모음

// 2) spring-boot-starter-test
// : 스프링 애플리케이션의 테스트를 위한 의존성 모음

// 3) validation: 유효성 검사를 위한 의존성 모음
// 4) actuator: 모니터링을 위한 정보 제공
// 5) data-jpa: ORM을 사용하기 위한 인터페이스 모음인 JPA를 쉽게하기 위함



