package praktikum.Core2.UnitTest.test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ArraysTest {
    /*
    Есть ещё одна важная особенность, связанная с методом equals(..).
    Его нельзя переопределить для массивов.
    Другими словами, два массива с одинаковым содержанием
    (одинаковыми элементами, расположенными в том же порядке)
     — это разные объекты с точки зрения Java.
     */

    @Test
    public void arraysShouldBeEqual() {
        String[] arrayOne = new String[] {"hello", "world" };
        String[] arrayTwo = new String[] {"hello", "world" };

        System.out.println("Равенство массивов: " + Arrays.equals(arrayOne, arrayTwo));

        assertArrayEquals(arrayTwo, arrayOne, "Массивы не равны!");
    }
}
