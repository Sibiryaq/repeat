package dmdev;

/**
 * Имеется целои число, вводимое пользователем с консоли. Это число - сумма денег в рублях.
 * Вывести это число, добавив к нему слово рубль в правильном падеже
 */
public class Task3 {
    public static void main(String[] args) {
        int rubles = 122;
        int div1 = rubles % 10;
        int div2 = rubles % 100;
        if (div1 == 1 && div2 != 11) {
            System.out.println(rubles + " рубль");
        } else if (div1 == 0 || (div2 >= 5 && div2 <= 20)) {
            System.out.println(rubles + " рублей");
        } else {
            System.out.println(rubles + " рубля");
        }
    }
}
