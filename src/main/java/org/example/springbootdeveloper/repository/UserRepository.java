package org.example.springbootdeveloper.repository;

import org.example.springbootdeveloper.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // User 타입의 엔티티의 "필드를 선택적으로 가져올 수 있는" 타입 정의
    Optional<User> findByEmail(String email);

    // 해당 엔티티에 전달하는 email이 존재할 경우 true, 존재하지 않을 경우 false를 반환
    boolean existsByEmail(String email);
}
