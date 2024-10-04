package dmdev;

/**
 * Заносит в массив 100 первых чисел, делящихся на 13 ИЛИ на 17, и  печетает их
 */
public class Task4 {
    public static void main(String[] args) {
        int[] values = new int[100];
        fillArray(values);
        Task1.printArray(values);
    }

    public static void fillArray(int[] values) {
        int currentIndex = 0;
        for (int currentValue = 1; currentIndex < values.length ; currentValue++ ) {
            if (currentValue % 13 == 0 || currentValue % 17 == 0) {
                values[currentIndex] = currentValue;
                currentIndex++;
            }
        }
    }
}
