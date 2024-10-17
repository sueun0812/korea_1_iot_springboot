package org.example.이론;

public class i_test {

    // 테스트 코드

    // 1. 테스트 코드란?
    // : 애플리케이션이 의도한 대로 자동하는지 확인하기 위해 작성된 "코드"
    // : 개발자가 직접 코드의 결과를 수작업으로 확인하는 대신
    //   , "자동화된 테스트"로 특정 기능이 올바르게 동작하는지를 반복적으로 확인

    // 2. 테스트 코드의 종류
    // : 단위 테스트, 통합 테스트, 기능 테스트, 회귀 테스트

    // cf) 테스트 코드는 src 디렉터리 내의 test 디렉터리에서 작업

    // 3. given-when-then 패턴
    // : 테스트 코드를 세 단계로 구분해 작성하는 방식
    // 1) given
    // : 테스트의 실행을 준비하는 단계
    // 2) when
    // : 테스트를 진행하는 단계
    // 3) then
    // : 테스트 결과를 검증하는 단계

    // 4. 스프링 부트 3 테스트
    // : spring-boot-starter-test : 테스트를 위한 도구 모음
    // 스프링 부트 스타터 테스트 목록
    // - JUnit 5 : 자바 프로그래밍 언어용 단위 테스트 프레임워크
    //   : 테스트 방식을 구분할 수 있는 애너테이션을 제공
    //   : @Test를 사용 : 메서드 호출 시 새 인스턴스생성, 독립 테스트 가능

    // - Spring Test & Spring Boot Test : 스프링 부트용 통합 테스트 지원
    // - AssertJ : 검증문인 Assertion을 작성하는데 사용되는 라이브러리
    //   : JUnit과 함께 사용
    //   : 검증문의 가독성을 향상

    // cf) Assertions.assertEquals(sum, a + b);
    // 기댓값: sum
    // 실제 비교값: a + b
    // >> 코드만 보고 기댓값과 비교값이 잘 구분되지 않음

    // AssertJ를 사용하여 가독성 향상
    // cf) assertThat(a + b).isEqualTo(sum);
    // : a와 b를 더한 값이 sum과 같아야한다. 는 의미

    // AssertJ의 메서드
    // - isEqualTo(A): A 값과 같은지 검증
    // - isNotEqualTo(A): A 값과 다른지 검증
    // - contains(A): A 값을 포함하는지 검증
    // - doesNotContains(A): A 값을 포함하지 않는지 검증
    // - startsWith(A): 접두사가 A인지 검증
    // - isEmpty(): 비어있는 값인지 검증
    // - isNotEmpty(): 비어있지 않은 값인지 검증
    // - isPositive(): 양수인지 검증
    // - isNegative(): 음수인지 검증
    // - isGreaterThan(1): 1보다 큰 값인지 검증
    // - isLessThan(1): 1보다 작은 값인지 검증
}
