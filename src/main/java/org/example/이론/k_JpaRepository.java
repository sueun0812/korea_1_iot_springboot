package org.example.이론;

public class k_JpaRepository {
    // JpaRepository
    // : Spring Data JPA에서 제공하는 기본 인터페이스
    // : CRUD와 페이징, 정렬을 포함한 다양한 데이터 엑세스 메서드를 제공

    // 1. CRUD 메서드

    // 1) save(S entity): S
    // - 새로운 엔터티를 저장하거나, 기존 엔터티를 업데이트

    // 2) findById(ID id)
    // - 주어진 ID에 해당하는 엔터티를 조회

    // 3) existsById(ID id): boolean
    // : 주어진 ID가 존재하는지 확인

    // 4) findAll()
    // : 데이터베이스에 있는 모든 엔티티를 조회

    // 3) deleteById(ID id): void
    // 주어진 ID의 엔티티를 삭제

    // 2. JpaRepository<타입1, 타입2>의 구조
    // 1) 타입1
    // : 엔티티(Entity) 클래스 타입
    // : DB 테이블과 매핑되는 클래스
    // 2) 타입2
    // : 엔티티의 ID 타입
    // : 해당 엔티티의 기본 키 필드에 사용된 데이터 타입

    // 3. 쿼리 메서드 사용
    // : 사용자 정의 메서드

    // - 메서드 이름으로 쿼리 생성
    // : 메서드 이름을 분석해 자동으로 쿼리 생성
    // : 주로 WHERE, LIKE, BETWEEN, ORDER BY를 지원

    // findById(ID id);
    // find: 조회(select)
    // By: 뒤의 키워드로 조회

    // EX1) '가격'이 특정 금액 '이상'인 '상품' '조회'
    // findByPriceGreaterThan(int price);
    // -GreaterThan (이상)

    // EX) '이름'에 특정 문자열이 '포함'된 '상품' '조회'
    // findByNameContaining(String keyword);
    // - Containing (포함)

    // EX3) '카테고리'가 일치하고 '가격'이 '특정 범위'에 있는 상품 조회
    // findByCategroyAndPriceBetween(String category, int minPirce, int maxPirce);

    // EX4) '특정 날짜' 이후에 생성된 '상품' 조회
    // findByCreateDateAfterOrderByCreatedDatedDesc(LocalDate date);
    // find By CreateDate After OrderBy CreatedDated Desc(LocalDate date);
    // - After (이후)
    // - OrderBy (A를 기준으로 정렬)
    // - Desc (내림차순)

    // - @Query 어노테이션을 사용해 직접 SQL 작성
    // findByPriceGreaterThan(1000)
    // : SELECT * FROM product WHERE price > 1000;

    // @Query("SELECT * FROM Product p WHERE p.price > :price")
    // 반환타입 findProductsByPrice(@Param("price") int price);

    // findByNameContaining("Phone")
    //? : SELECT * FROM product WHERE productName = "Phone";

    // findByCategoryAndPriceBetween("Electronics", 500, 1500)
    // findByCreateDateAfterOrderByCreatedDateDesc(LocalDate.of(2023, 1, 1))


    // - @Query 어노테이션을 사용해 직접 SQL 작성


}
