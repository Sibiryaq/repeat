package dmdev;

/**
 * Печатает массив сначала в обычном порядке ,затем в обратном
 */
public class Task1 {
    public static void main(String[] args) {
        int[] values = {1, 5, 7, 8, 9};
        printArray(values);
        printArrayForEach(values);
        printArrayReverse(values);

    }

    static void printArray(int[] values) {
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }
        System.out.println();
    }

    static void printArrayForEach(int[] values) {
        for (int e :values) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    static void printArrayReverse(int[] values) {
        for (int i = values.length - 1; i >= 0; i--) {
            System.out.print(values[i] + " ");
        }
        System.out.println();
    }
}
