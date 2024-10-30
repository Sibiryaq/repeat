package praktikum.Core2.alghorithm;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        final String mergeSort = "Работает быстро, но требует дополнительной памяти," +
                " сохраняет относительный порядок элементов - допустим по имени и по цене";
        final String quickSort = "Тоже работает быстро, доп.памяти не требует, " +
                "НО только один порядок сортировки, или по цене или по имени";

        int[] array = {7, 4, 2, 0, 1, 3, 4, 9};
        System.out.println(Arrays.toString(array));

        insertionSort(array);
        System.out.println(Arrays.toString(array));

    }

    public static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }

            array[j + 1] = key;
        }
    }

    public static void radixSort(int[] array) {
        int n = array.length;
        int[] counter = new int[10];

        for (int i = 0; i < array.length; i++) {
            counter[array[i]] += 1;
        }

        int i = 0;

        for (int j = 0; j < counter.length; j++) {
            if (counter[j] > 0) {
                for (int k = 1; k <= counter[j]; k++) {
                    array[i] = j;
                    i++;
                }
            }
        }
    }


}
