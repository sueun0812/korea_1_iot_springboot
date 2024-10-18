package org.example.이론;

public class o_API설계서 {
    /*
        API 설계(명세)서: User API
        ----------------------------
        API 명세서 설명: User API는 회원 가입, 로그인, 사용자 조회, 수정, 삭제 기능을 제공합니다.

        === 모듈 이름: 회원 가입 ===
        모듈 설명 - 기능: 새로운 사용자를 등록합니다.
        모듈 URL - URL: POST http://localhost:4040/api/v1/user/sign-up

        == Request ==
        (Header)
        - Host: 요청이 전송되는 URL
        - User-Agent: 요청을 보내는 클라이언트에 대한 정보
        - Content-Type: 요청을 보내는 메시지 타입 EX) application/json
        - Content-Length: 요청하는 메시지 길이


        Request Body
        필드명/데이터타입/필수여부/설명
        ...

        Request Example(요청 예시)
        POST http://localhost:4040/api/v1/user/sign-up
        {
            "userId": "qwe123",
            "userPassword": "qwerty12345",
            "userEmail": "asd123",
            "userAge": 32
        }

        == Response ==
        Response Data
        필드명/데이터 타입/필수 여부/설명
        code/string/O
            /결과에 대한 코드
            (성공: SU, 요청 매개변수 검증 실패: VF, 존재하는 회원 이메일: EU
            , 존재하는 회원 닉네임: EN, 존재하는 회원핸드폰 번호: EP, 데이터베이스 오류: DE)
        - message: 결과에 대한 메시지(영어로 작성 EX) Success, Request Parameter Validation Failed)
        - 데이터(선택): 회원 코드, 생성 시 자동 생성
     */
}
