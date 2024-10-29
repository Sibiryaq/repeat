package praktikum.Core2.asymptoticComplexity;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        lesson1 x = new lesson1();
        double[] massive = {1.0, 2.0, 3.0};
        System.out.println("Наибольшее число" + x.getMax(massive));

        int[] array = {1, 2, 65, 3, 5, 7, 54, 12, 46, 4, 2};
        System.out.println("Индекс искомого элемента: " + lesson1.find(array, 3));
        Arrays.sort(array); //ничего не вернет, но отсортирует данные
        System.out.println("Индекс искомого элемента: " + Arrays.binarySearch(array, 3));
    }
}

