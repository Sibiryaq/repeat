package praktikum.Core2.UnitTest.test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class MathsTest {
    // Assertions - множество статических методов класса, принимает 2 или 3 аргумента
    // третий аргумент - строка, которая выведется если фактический результат НЕ равен ожидаемому

    @Test
    public void testSum() {
        int term1 = 2;
        int term2 = 3;

        int sum = term1 + term2;
        Assertions.assertEquals(5, sum);
    }

    @Test
    public void testMultiplication() {
        int factor1 = 2;
        int factor2 = 3;

        int production = factor1 * factor2;

        assertEquals(6, production, "production value is wrong");
    }

    @Test
    public void shouldBeNull() {
        // import static org.junit.jupiter.api.Assertions.*; импортировали все методы сразу
        assertNull(null);
    }

    @Test
    public void shouldNotBeNull() {
        String apple = "apple";
        assertNotNull(apple);
    }

    @Test
    public void shouldBeTrue() {
        boolean value = true;
        assertTrue(value);
        // можно assertEquals(true, value); но тогда используется equals() из класса Object
        // НО нужно быть уверенным, что он переопределен корректно
    }

    @Test
    public void shouldBeFalse() {
        boolean value = false;
        assertFalse(value);
    }




}
