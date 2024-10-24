package org.example.springbootdeveloper.common.constant;

public class ApiMappingPattern {
    // 인증 절차 생성 로직
    // : 회원가입, 로그인
    public static final String AUTH = "/api/auth";

    // 일반 회원 관련 로직: 회원 조회(단건, 전체, 필터링), 수정, 삭제
    public static final String USER = "/api/users";

    public static final String POST = "/api/posts";
    public static final String BOOK = "/api/books";
//    public static final String GROUP = "/api/v1/group";
}