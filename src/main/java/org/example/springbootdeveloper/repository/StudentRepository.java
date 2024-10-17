package org.example.springbootdeveloper.repository;

import org.example.springbootdeveloper.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// StudentRepository 인터페이스
// : JpaRepository를 상속받음

// cf) implements 키워드
//     : 인터페이스를 구현하는 메서드
//     : class 클래스명 implements 인터페이스
public interface StudentRepository extends JpaRepository<Student, Long> {
    // : JpaRepository 인터페이스를 상속받음
    // : 해당 인터페이스는 기본적인 CRUD와 페이징, 정렬의 메서드가 포함
    // >> 직접 구현할 필요 없음, 인터페이스만 선언하면 스프링이 자동으로 구현체를 만들어 줌
    // >> 필요한 경우 사용자 정의 쿼리 추가 가능
}
