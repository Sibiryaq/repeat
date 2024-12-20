package praktikum.Core2.exceptions;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /**
         * объединение двух и более исключений с ОДИНАКОВЫМ выводом с помощью |
         * Класс: stack.getClassName()
         * метод: stack.getMethodName()
         * имя файла: stack.getFileName()
         * строка кода: stack.getLineNumber()
         * e.printStackTrace();
         * -
         * Отлавливаем от более частного в иерархии к более общему
         * System.out.println(e.getMessage()) -можно использовать для исключений
         * где есть контрукторы Throwable с параметром String message, иначе вернет null
         */
        System.out.println(convertToString(0));

        try {
            new ArrayList<String>().add("1");
        } catch (UnsupportedOperationException | IllegalArgumentException exception) {
            System.out.println("Возникла ошибка, свяжитесь с нами!");
        }

        try {
            calculate1();
        } catch (ArithmeticException exception) {
            for (StackTraceElement stack : exception.getStackTrace()) {
                System.out.println(String.format(
                        "Класс: " + stack.getClassName() + ", " + //еще доп.методы
                                "метод: " + stack.getMethodName() + ", " +
                                "имя файла: " + stack.getFileName() + ", " +
                                "строка кода: " + stack.getLineNumber()));
            }
        }

    }

    private static String convertToString(Object x) {
        try {
            return (String) x;
        } catch (ClassCastException e) {
            System.out.println("Некорректное приведение типов");
        } catch (RuntimeException e) {
            System.out.println("Ошибка во время выполнения");
        } catch (Exception e) {
            System.out.println("Произошла неизвестная ошибка");
        }
        return null;
    }

    public static void calculate1() {
        calculate2();
    }

    public static void calculate2() {
        System.out.println(10 / 0);
    }

}

