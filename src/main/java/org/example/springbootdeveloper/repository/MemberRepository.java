package org.example.springbootdeveloper.repository;

import org.example.springbootdeveloper.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// DB에서 데이터를 가져오는 퍼시스턴스 계층
// : member 테이블에 접근해서 Member 클래스에 매핑하는 구현체
public interface MemberRepository extends JpaRepository<Member, Long> {
}
