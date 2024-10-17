import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JUnitTest {
    // @DispalyName
    // : 테스트 이름을 명시
    @DisplayName("1 + 2는 3이다.")
    // @Test
    // : 해당 애너테이션을 붙인 메서드는 테스트를 수행하는 메서드
    @Test
    public void junitTest() {
        int a = 1;
        int b = 2;
        int sum = 3;

        // .assertEquals
        // : JUnit에서 제공하는 검증 메서드
        // : 첫 번째 인자 - 기대하는 값
        // : 두 번째 인자 - "실제로" 검증할 값

        Assertions.assertEquals(sum, a + b);
    }

//    @DisplayName("1 + 3는 4이다.")
//    @Test
//    public void junitFailedTest() {
//        int a = 1;
//        int b = 3;
//        int sum = 3;
//
//        Assertions.assertEquals(sum, a + b);
//    }
}
