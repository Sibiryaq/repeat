package praktikum.Core2.streams;

import java.util.Arrays;
import java.util.List;

public class ComparatorDemo {
    public static void main(String[] args) {
        List<Circle> circles = Arrays.asList(
                new Circle(3, 5, 12),
                new Circle(1, -2, 4),
                new Circle(8, 8, 8),
                new Circle(5, 1, 7)
        );

        // вместо компаратора используем лямбду
        circles.sort((circle1, circle2) -> {
            return circle1.getRadius() - circle2.getRadius();
        });

        for (Circle circle: circles) {
            System.out.println(circle);
        }
    }
}
