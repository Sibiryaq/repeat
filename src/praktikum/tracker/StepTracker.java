package praktikum.tracker;

import java.util.Scanner;

public class StepTracker {
    int[][] monthData = new int[12][30];
    int goalSteps = 10000;

    Converter converter = new Converter(75, 50);
    Scanner scanner = new Scanner(System.in);

    void changeGoalSteps() {
        int newGoalSteps = setSteps();
        if (newGoalSteps > 0) {
            goalSteps = newGoalSteps;
            System.out.println("Ваша новая цель, с которой вы обязательно справитесь: " + goalSteps);
        } else {
            System.out.println("Данные не могут быть отрицательными.");
        }
    }


    int setMonth() {
        System.out.println("Введите месяц");

        while (true) {
            int month = scanner.nextInt();
            if (month > 0 && month < 13) {
                return month;
            } else {
                System.out.println("Проверьте ввод, должно быть от 1 до 12");
            }
        }
    }


    int setDay() {
        System.out.println("Введите день");

        while (true) {
            int day = scanner.nextInt();
            if (day > 0 && day < 31) {
                return day;
            } else {
                System.out.println("Проверьте ввод, должно быть от 1 до 30");
            }
        }
    }

    void saveSteps() {
        monthData[setMonth() - 1][setDay() - 1] = setSteps();
    }

    int setSteps() {
        System.out.println("Введите количество шагов");
        while (true) {
            int steps = scanner.nextInt();
            if (steps > 0) {
                return steps;
            } else {
                System.out.println("Данные не могут быть отрицательными.");
            }
        }
    }


    void getStatistic() {
        int month = setMonth();
        printStepsMonth(month);
        System.out.println("Общее количество шагов за месяц: " + findSumSteps(month));
        System.out.println("Максимальное количество шагов: " + printMaxStepsMonth(month));
        printAveragedStepsMonth(month);
        printDistanceOnMonth(month);
        printBurnCalories(month);
        System.out.println("Лучшая серия: " + maxSequence(month));

    }

    void printStepsMonth(int month) {
        for (int i = 0; i < monthData[month - 1].length; i++) {
            System.out.println((i + 1) + " день: " + monthData[month - 1][i] + ",");
        }
    }


    int findSumSteps(int month) {
        int sum = 0;
        for (int i = 0; i < monthData[month - 1].length; i++) {
            sum += monthData[month - 1][i];
        }
        return sum;
    }

    int printMaxStepsMonth(int month) {
        int maxSteps = 0;
        for (int i = 0; i < monthData[month - 1].length; i++) {
            if (monthData[month - 1][i] > maxSteps) {
                maxSteps = monthData[month - 1][i];
            }
        }

        return maxSteps;
    }

    void printAveragedStepsMonth(int month) {
        int sum = findSumSteps(month);
        System.out.println("Среднее количество шагов: " + (sum / monthData[month - 1].length));

    }

    void printBurnCalories(int month) {
        int stepsTotal = findSumSteps(month);
        converter.convertCalories(stepsTotal);
        System.out.println("Количество сожженных килокалорий: " + converter.convertCalories(stepsTotal) + " Ккал");
    }

    void printDistanceOnMonth(int month) {
        int stepsTotal = findSumSteps(month);
        converter.convertStepsInKm(stepsTotal);
        System.out.println("Пройденная дистанция: " + converter.convertStepsInKm(stepsTotal) + " км");

    }

    int maxSequence(int month) { // Лучшая серия
        int max = 0;
        int predmax = 0;

        for (int i = 0; i < monthData[month - 1].length; i++) {
            if (monthData[month - 1][i] >= goalSteps) {
                predmax = predmax + 1;
                if (predmax > max) {
                    max = predmax;
                }
            } else {
                predmax = 0;
            }
        }

        return max;
    }
}
