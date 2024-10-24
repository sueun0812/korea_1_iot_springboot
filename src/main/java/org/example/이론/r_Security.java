package org.example.이론;

public class r_Security {
    /*
        1. WebSecurityConfig
        : Spring Security 설정을 담당하는 파일 (전반적인 보안 정책을 정의)
        - 인증 방식(JWT 사용), 인증이 필요한 URL, 필터 순서를 설정

        - 흐름 -
        : 애플리케이션 실행 시 Spring Boot는 config 파일을 기반으로 보안 관련 설정을 적용
        : JwtAuthenticationFilter와 같은 필터들을 언제, 어떻게 적용할지 설정
            & 어떤 요청 경로가 인증이 필요하고 어떤 경로가 공개될지 설정
        : HTTP 요청에 대한 인증/인가 정책을 정의
            > JWT 기반 토큰 인증을 적용, 특정 경로는 인증 없이 접근할 수 있도록 설정

        2. JwtProvider
        : JWT 토큰을 생성하고, 검증하는 역할
        - JWT의 발급, 만료 기간 확인 등의 작업을 처리

        - 흐름 -
        : 사용자가 로그인하면 JWTProvider는 로그인 정보(사용자 이름, 권한 등)를 기반으로 JWT 토큰 생성
        : 이후 사용자가 보낸 요청에 JWT 토큰을 추출하면 JwtProvider가 토큰의 유효성을 검증
            > 토큰의 만료 여부 확인, 유효하다면 토큰에서 사용자 정보를 추출하여 인증 처리

        3. JwtAuthenticationFilter
        : JWT 기반 인증을 처리하는 필터
        - 사용자가 요청을 보낼 때 헤더에 포함된 JWT 토큰을 확인하여 해당 요청을 인증하는 역할
        - HTTP 요청이 Controller에 전달되기 전에 실행되어 JWT 토큰의 유효성을 검사

        - 흐름 -
        : 사용자가 로그인 성공 시 서버가 JWT 토큰을 생성하여 응답으로 전달 (JwtProvider)
        : 사용자가 이후 요청 시 Authorization 헤더에 "Bearer 토큰" 형식으로 JWT 토큰을 전달
        : JwtAuthenticationFilter는 요청을 가로채 Authorization에서 JWT 토큰을 추출

        cf) 로그인 시 - jwtProcider (토큰X)
            인증, 인가 처리가 필요 시 - JwtAuthenticationFilter (토큰O)

        : 추출한 JWT 토큰을 JwtProcider에게 전달하여 유효성 검사를 진행
        : 토큰이 유효하다면 Authentication 객체를 생성하여 SecurityContext에 저장
            , 이후 요청이 해당 사용자 권한에 따라 처리
        : 토큰이 유효하지 않다면 인증되지 않은 상태로 요청이 처리



     */
}
