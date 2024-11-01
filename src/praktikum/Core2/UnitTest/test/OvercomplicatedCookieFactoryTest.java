package praktikum.Core2.UnitTest.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

public class OvercomplicatedCookieFactoryTest {
    private static OvercomplicatedCookieFactory cookieFactory;

    /*
    порядок запуска тестов в общем случае не определён.
    Более того, он может меняться от запуска к запуску
    поэтому нужно подготавливать етсовую среду, например аннотацией BeforeEach
     */
    @BeforeEach
    public void beforeEach() {
        cookieFactory = new OvercomplicatedCookieFactory(
                Collections.singletonList("Вам повезёт!"),
                Collections.singletonList("Сегодня будет дождь."),
                true
        );
    }

    @Test
    public void shouldReturnPositiveCookie() {
        String cookieText = cookieFactory.bakeFortuneCookie();
        Assertions.assertEquals("Вам повезёт!", cookieText);
    }

    @Test
    public void shouldIncreaseCounterByOneAfterCookieBaked() {
        cookieFactory.bakeFortuneCookie();
        Assertions.assertEquals(1, cookieFactory.getCookiesCreated());
    }
}
