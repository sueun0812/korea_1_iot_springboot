package org.example.이론;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class j_ORM {

    // 1. ORM(Object-Relational Mapping)
    // : 객체와 관계형 데이터베이스 간의 데이터를 매핑해주는 기술
    // - 데이터베이스의 테이블과 애플리케이션의 객체 간의 구조적 불일치를 해결하는 솔루션

    // cf) RDBMS: user_password (lower_snake_case) - 테이블
    // cf) JAVA: userPassword (lowerCamelCase) - 클래스

    // 1) ORM의 특징
    // - 객체와 테이블이 매핑: 1:1로 연결하여 데이터를 매핑
    // - 객체지향적인 데이터 조작: SQL 대신 자바 객체 메서드로 CRUD 작업 수행
    // >> 반복적인 SQL 작성 없이 데이터 조작 가능, DBMS에 독립적
    // >> 학습 곡선 높음, 복잡한 쿼리 작성 어려움

    // 2) ORM의 동작 원리
    // : 각 테이블은 클래스에, 테이블의 각 행(row)은 객체에 매핑
    // - Entity: 데이터베이스 테이블과 매핑되는 클래스
    // - Field: 클래스의 필드는 테이블의 열(column)에 해당

    // 2. JPA(Java Persistence API)
    // : ORM의 종류 중 하나
    // > Java 애플리케이션에서 관계형 데이터베이스를 쉽게 다룰 수 있는 ORM 표준

    // +) 영속성 컨텍스트
    //    : 엔티티의 생명 주기를 관리하는 공간
    //    : DB와의 연결을 유지하면서 엔티티 객체들을 관리

//    === 고객 테이블(Customer) ===
//    create table Customer (
//      id int primary key auto_increment,
//      name varchar(50),
//      emila varchar(50)
//    );

    // === 고객 클래스(Customer) ===
//    @Entity
//    public class Customer {
//        @Id
//        @GeneratedValue(strategy = GenerationType.IDENTITY)
//        private int id;
//
//        private String name;
//        private String email;
//    }

    // 3. ORM에서 사용되는 주요 애너테이션
    // @Entity
    // : 클래스를 DB 테이블과 매핑할 때 사용
    // - 옵션 없이 사용 가능
    // +) name 옵션: 엔티티 이름을 지정, 테이블명과 다를 경우 명시
    //    EX) @Entity(name = "UserTable")
    //        public class user {}

    // @Id
    // : 해당 필드를 DB 테이블의 기본 키로 지정
    // - 옵션 없이 사용, 다른 애너테이션과 함께 기본 키 생성 방식이나 타입 설정 가능
    //   +) 주로 GeneratedValue와 함께 사용

    // @GeneratedValue
    // : 기본 키 자동 생성 전략 설정
    // +) 다양한 옵션이 있음
    //    - strategy 옵션: GenerationType.IDENTITY(auto_increment)

    // @Column
    // : 필드를 특정 테이블 열과 매핑
    // : 생략 시 기본으로 필드 이름이 열 이름으로 사용
    // +) 다양한 옵션이 있음
    //    - name 옵션: 열 이름 지정
    //    - nullable 옵션: 열이 Null 값을 허용할지 여부를 설정 (기본값 true -> Null이 될 수 있다.!)
    //    - length 옵션: String 타입의 열 길이를 지정 (기본값 255)
    //    - unique 옵션: 해당 필드의 값이 유일해야 하는지 여부를 지정 (기본값 false)

    // @Table
    // : 클래스가 어떤 테이블과 매핑되는지 명시
    // +) 생략 시 기본으로 클래스 이름이 테이블 이름으로 사용
    // +) name 옵션

    // cf) 옵션은 '옵션명 = 옵션사항'으로 명시
    //     각 옵션은 ,(콤마)로 구분
    // @Column(name = "user_password", nullable = false, unique = true)

    // cf) JPA(ORM, 객체와 RDMS의 연결) VS MyBatis(SQL Mapper, SQL 중심 접근)

    // == 환경 설정 ==
    // 1) build.gradle
    // 필요한 의존성: Spring Data JAP, MySQL Driver

    // 2) application.properties, application.yml
    // 애플리케이션 설정: 연결할 DB와 사용자 정보, 비밀번호 등을 설정
}
