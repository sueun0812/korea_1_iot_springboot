package org.example.springbootdeveloper;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

// @SpringBootApplication 애너테이션
// : 스프링 부트에 필요한 기본 설정을 제공

// @SpringBootConfiguration
// : 스프링 부트 관련 설정 - @Configuration을 상속 받음

// @ComponentScan
// : 사용자가 등록한 빈을 읽고 등록
// : @Component라는 애너테이션을 가진 클래스를 찾아 빈으로 등록하는 역할

// - @Configureation: 설정 파일 등록
// - @Repository: ORM 매핑
// - @Controller, @RestController: 라우터
// - @Service: 비즈니스 로직

// @EnableAutoConfiguration
// : 스프링 부트에서 자동 구성을 활성화하는 애너테이션

@SpringBootApplication
public class SpringBootDeveloperApplication {
    public static void main(String[] args) {
        // SpringApplication.run()
        // : 애플리케이션 실행
        // - 첫 번째 인자: 스프링 부트3 애플리케이션의 메인 클래스로 사용할 클래스
        // - 두 번째 인자: 커맨드 라인의 인수들을 전달
        SpringApplication.run(SpringBootDeveloperApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner run(ApplicationContext ctx) {
//        return args -> {
//            BookStore2 store2 = ctx.getBean(Bookstore2.class);
//            store2.displayBook();
//        }
//    }
}
