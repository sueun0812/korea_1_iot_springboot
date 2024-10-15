package org.example.이론;

public class h_dispatchServlet {
    // === DS (DispatchServlet)
    // : 스프링 부트의 핵심 서블릿
    // : 클라이언트의 요청을 받아 "알맞은 핸들러(Controller)"를 찾아 실행하고
    //   , 처리된 결과를 다시 클라이언트에게 반환
    // >> HttpServletRequest / HttpServletResponse
    // : "웹 애플리케이션의 요청 흐름"을 관리하는 중심 역할

    // === DispatchServlet의 동작 과정
    // 1. 클라이언트 요청 처리
    // : 사용자가 웹에서 요청(Get, Post, Put, Delete)을 보냄
    // : 서블릿 컨테이너가 DS로 요청을 전달

    // 2. Handler(Controller) 조회
    // : HandlerMapping을 통해 요청 URI에 맞는 "핸들러"를 찾음
    // EX) /student로 요청 > StudentController가 매핑

    // 3. Handler Adapter 조회
    // : 매핑한 핸들러 실행을 위한 어댑터를 찾고
    //   , Controller가 실행될 수 있는 형태로 어댑터가 변환

    // 4. Handler(Controller) 실행
    // : Handler Adapter가 찾은 핸들러를 실행
    // : 핸들러가 요청을 처리하고, 결과를 어댑터로 반환

    // 5. @RestController 사용 시
    // >> View와 ViewResolver를 거치지 않음
    // : MessageConverter를 통해 JSON 형식으로 변환
    // : ResponseBody에 담겨 JSON 데이터가 클라이언트에게 전달
}
