package org.example.이론;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public class l_requestParam_requestBody {
    // @RequestParam & @RequestBody
    // : Spring에서 클라이언트로부터 데이터를 받는 방식

    // 1. @RequestParam
    // : 클라이언트가 URL 쿼리 스트링 또는 폼 데이터로 전달한 데이터를
    //   , 컨트롤러 메서드의 파라미터로 받을 때 사용
    // >> 주로 GET 요청에서 많이 사용
    // >> 데이터를 URL 뒤에 붙여서 전달하는 경우

    // - URL에서 데이터를 전달할 때: 검색 조건, 필터링 등의 간단한 데이터를 요청할 때
    // - GET 요청
    // - 보안에 덜 민감한 데이터

    // +) @RequestParam 기본값 해제 & 기본값 설정
    // : @RequestParam 값이 없을 경우 오류
    // 1) 필수값 설정 해제
    // public String getName(@RequestParam(required = false) String name) {
    // }

    // 2) 기본값 설정
    // public String getName(@RequestParam(required = false, defaultValue = "default") String name) {
    // }

    // 2. @RequestBody
    // : HTTP 요청의 본문(Body)에 담긴 JSON 또는 XML 같은 데이터를
    //   , 객체로 변환하여 받을 때 사용
    // >> 주로 POST, PUT, DELETE와 같은 요청에서 데이터를 전송할 때 사용

    // - POST/PUT 요청에서 데이터를 전달
    // - 복잡한 데이터 구조: 주로 DTO(Data Transfer Object)를 사용해 데이터를 변환
    // - 보안이 중요한 경우
}
