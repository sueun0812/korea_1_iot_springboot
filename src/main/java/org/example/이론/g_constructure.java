package org.example.이론;

public class g_constructure {

    // 스프링 부트의 구조

    // 클라이언트 - Controller - Service - Repository - 데이터베이스

    // 1) 프레젠테이션(Presentation) 계층
    // : 컨트롤러(Controller)
    // : HTTP 요청을 받고 해당 요청을 비즈니스 계층으로 전송하는 역할

    // 2) 비즈니스(Business) 계층
    // : 서비스(Service)
    // : 모든 비즈니스 로직을 처리
    // cf) 비즈니스 로직
    //     : 서비스를 만들기 위한 로직, 웹 사이트에서 벌어지는 모든 작업

    // 3) 퍼시스턴스(Persistence) 계층
    // : 리포지토리(Repository)
    // : 모든 데이터베이스 관련 로직을 처리
    // > DB에 접근하는 DAO 객체를 사용 가능

    // cf) DAO: 데이터베이스와 상호 작용을 위한 객체
}
