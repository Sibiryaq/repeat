package praktikum.Core2.asymptoticComplexity;

/**
 * О-нотация, 1894 Пауль Бахман
 * лучший, худший и средний случай
 */
public class lesson1 {
    static final String O_N = "Линейная сложность, чем больше данных, тем больше операций";
    static final String O_LOG_N = "Логарифмическая сложность, кол-во операций растет как двоичный логарифм";
    static final String O_1 = "Константная сложность, не зависит от кол-ва элементов";


    double getMax(double[] massiveNumbers) {
        double max = massiveNumbers[0];
        for (int i = 0; i < massiveNumbers.length; i++) {
            if (massiveNumbers[i] > max) {
                max = massiveNumbers[i];
            }
        }
        return max;
    }

    public int getMin(int[] arrays) {
        int min = arrays[0];
        for (int elem :arrays) {
            if (elem < min) {
               min = elem;
            }
        }
        System.out.println("O(n) - так как нужно пройтись по всем элементам массива");
        return min;
    }

    public static int find(int[] array, int elem) {
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == elem) {
                index = i;
            }
        }
        return index;
    }

    public int findBinary(int[] array, int elem) {
        int index = -1;

        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low  + ((high - low) / 2);

            if (array[mid] < elem) {
                low = mid + 1;
            } else if (array[mid] > elem) {
                high = mid - 1;
            } else if (array[mid] == elem) {
                index = mid;
                break;
            }
        }
        return index;
    }
}
