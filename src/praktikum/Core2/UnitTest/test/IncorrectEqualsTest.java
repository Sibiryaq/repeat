package praktikum.Core2.UnitTest.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class IncorrectEqualsTest {

    @Test
    public void shouldReturnEquals() {
        Item item1 = new Item("Яблоки", 50);
        Item item2 = new Item("Яблоки", 50);

        assertEquals(item2, item1);
    }

}
