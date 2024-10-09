package alishev;

public class WhileLoops {
    public static void main(String[] args) {
        boolean t = 5 >= 5;
        System.out.println(t);
        boolean y = 1 == 2;
        System.out.println(y);

        int value = 0;
        while (value < 5) {
            value++;
            System.out.println("Текущее значение value: " + value);
        }

        int i = 0;
        while (true) {
            if (i == 15) {
                break; // мгновенный выход из цикла
            }
            System.out.println(i);
            i++;
        }


        for (int j = 0; j <= 15; j++) {
            if (j % 2 == 0) {
                continue;
            }
            System.out.println("Это нечетное число " + j);
        }

    }
}
