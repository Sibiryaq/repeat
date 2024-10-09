package dmdev;

import java.util.Scanner;

/**
 * 1. Дан порядоквый номер месяца
 */
public class Switch {
    //[модификаторы] [возвращаемый тип] [название] [параметры]
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        switch (month) {
            case 12, 1, 2 -> System.out.println("Зима");
            case 3, 4, 5 -> System.out.println("Весна");
            case 6, 7, 8 -> System.out.println("Лето");
            case 9, 10, 11 -> System.out.println("Осень");
            default -> System.out.println("Такого месяца не существует");
        }

        int value = 4;
        char charValue = switch (value) {
            case 1 -> 'a';
            case 2 -> 'b';
            default -> '0';
        }; // новая конструкция switch позволяет еще и возврашать значение
     /**
     * новый тип VAR, определяется на основании присваеваемого значения
     * можно использовать везде в ЛОКАЛЬНЫХ ПЕРЕМЕННЫХ,
     * после первого присваивания нельзя поменять на другой тип,
     * но можно изменить значение
     */
        var x = 1;
    }
}
