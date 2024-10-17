import org.junit.jupiter.api.*;

public class JUnitCycleTest {
    // 전체 테스트를 시작하기 전에 1회 실행
    // : static 키워드 사용 이유
    // : 객체를 생성하지 않고도(인스터스화 X) 호출될 수 있음
    // : 클래스가 로드될 때 한번만 실행
    @BeforeAll
    static void beforeAll() {
        System.out.println("@BeforeAll");
    }

    // 테스트 케이스를 시작하기 전 마다 실행
    // : public 설정
    @BeforeEach
    public void beforeEach() {
        System.out.println("@BeforeEach");
    }

    @Test
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() {
        System.out.println("test2");
    }

    @Test
    public void test3() {
        System.out.println("test3");
    }

    // 전체 테스트를 마치고 종료하기 전에 1회 실행하기 때문에
    // static 메서드로 선언
    @AfterAll
    static void afterAll() {
        System.out.println("@AfterAll");
    }

    // 테스트 케이스를 종료하기 전마다 실행
    @AfterEach
    public void afterEach() {
        System.out.println("@AfterEach");
    }
}

// @BeforeAll 클래스 레벨 설정
// @BeforeEach > @Test > @AfterEach가 테스트 개수만큼 반복
// @AfterAll 클래스 레벨 정리