package praktikum.Core2.collections.Comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final var a = new Student("aaa", 30);
        final var b = new Student("aaa", 27);
        final var c = new Student("ccc", 33);
        final var d = new Student("ddd", 21);

        // создаём изменяемый список из неизменяемого List.of(..)
        final var list = new ArrayList<>(List.of(a, b, c, d));
        Collections.sort(list);
        System.out.println(list);

        // выводим минимальный элемент в соответствии с правилами сортировки Comparable<Student>
        // так как список предварительно отсортирован, минимальным будет первый элемент
        System.out.println(Collections.min(list));

        // теперь напечатаем максимальный элемент
        System.out.println(Collections.max(list));
    }
}
