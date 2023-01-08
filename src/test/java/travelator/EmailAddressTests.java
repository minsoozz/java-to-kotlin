package travelator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * 동반 객체와 @JvmStatic 어노테이션을 사용하면 클래스를 코틀린으로 바꿔도 이런 정적 메서드 호출 코드를 변경할 필요가 없다.
 */
class EmailAddressTests {

    @Test
    void parsing() {
        assertEquals(
            new EmailAddress("fred", "example.com"),
            EmailAddress.parse("fred@example.com")
        );
    }

    @Test
    void parsingFailures() {
        assertThrows(
            IllegalArgumentException.class,
            () -> EmailAddress.parse("@")
        );
    }
}
