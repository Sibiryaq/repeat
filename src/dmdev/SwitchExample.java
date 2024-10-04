package dmdev;

/**
 * 1. Дан порядоквый номер месяца
 */
public class SwitchExample {
    public static void main(String[] args) {
        int month = 1;
        switch (month) {
            case 12, 1, 2 -> System.out.println("Зима");
            case 3, 4, 5 -> System.out.println("Весна");
            case 6, 7, 8 -> System.out.println("Лето");
            case 9, 10, 11 -> System.out.println("Осень");
            default -> System.out.println("Такого месяца не существует");
        }


    }
}
