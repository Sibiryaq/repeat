package dmdev;


/**
 * Написать метод equals, который определяет,
 * равны ли между собой соответсвующие элементы двумерных массивов
 */
public class Task5 {
    public static void main(String[] args) {
        int[][] values1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        int[][] values2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        System.out.println(equals(values1, values2));
    }

    public static boolean equals(int[][] values1, int[][] values2) {
        if (values1.length != values2.length) {
            return false;
        }
        for (int i = 0; i < values1.length; i++) {
            int[] row1 = values1[i];
            int[] row2 = values2[i];
            if (row1.length != row2.length) {
                return false;
            }
            for (int j = 0; j < row1.length; j++) {
                if (row1[j] != row2[j]) {
                    return false;
                }
            }
        }
        return true;
    }

}
