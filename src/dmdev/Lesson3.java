package dmdev;

public class Lesson3 {
    public static void main(String[] args) {
        int value = 5;
        int value2 = 3;
        int sum = value + value2;
        System.out.println(sum);

        int degree = value / value2;
        System.out.println(degree);// 5/3 = 1,6(6), но выведется только 1, т.к. degree типа int
        double degree2 = (double)value / value2; // когда одна из переменных double, все отработает коррректоно и будет 1,666....7
        System.out.println(degree2);

        int remainder = value % value2; // 5/3 = 1 и 2 в остатке
        System.out.println(remainder);

        int value3 = 5;
        value3 += 2; // запись идентична value3 = value3 + 2

        int value4 = 0;
        int value5 = 10;
        boolean test = value4 == 1;
        boolean test2 = value5 > 0;
        System.out.println(test && test2); // false
        System.out.println(test || test2); // true
    }
}
