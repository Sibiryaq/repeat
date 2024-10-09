package praktikum.switch1;

import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        switch(input) {
            case 1 :
                System.out.println("1"); // если без break то пойдет выполнять следующие
            case 2, 6 : // ждя 2х блоков 1 вариант обработки
                System.out.println("2");
                break;
            case 5 :
                System.out.println("5");
                break;
            default:
                System.out.println("Если ни один из, то этот");

        }

    }
}
