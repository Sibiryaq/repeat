package praktikum.tracker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(); // вызов, для подтягивая методов из класса praktikum.tracker.StepTracker

        while (true) {
            printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
            int input = scanner.nextInt(); // повторное считывание данных от пользователя

            if (input == 1) {
                stepTracker.saveSteps();
            } else if (input == 2) {
                stepTracker.getStatistic();
            }else if (input == 3) {
                stepTracker.changeGoalSteps();
            } else if (input == 0) {
                System.out.println("Выход");
                break;
            } else {
                System.out.println("К сожалению такой команды нет, выберите существующее действие.");
            }
        }

        System.out.println("Программа завершена");

    }

    private static void printMenu() {
        System.out.print("Что вы хотите сделать? \n" +
                "1 - Ввести количество шагов за определённый день \n" +
                "2 - Напечатать статистику за определённый месяц \n" +
                "3 - Изменить цель по количеству шагов в день \n" +
                "0 - Выйти из приложения");
    }

}
