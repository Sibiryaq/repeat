package alishev;

public class Arrays_of_Strings {
    public static void main(String[] args) {
        String[] stringsMassive = new String[5];
        stringsMassive[0] = "Hell0";
        stringsMassive[1] = "+";
        stringsMassive[4] = "Java";

        for (int i = 0; i < stringsMassive.length; i++) {
            System.out.println(stringsMassive[i]);
        }

        for (String string : stringsMassive) {
            System.out.println(string);
        }

        int[][] matrix = {
                {1, 2, 4},
                {4, 6, 8},
                {7, 8, 9,}};

        System.out.println(matrix[0][2]); // 4
        System.out.println(matrix[1][1]); // 6

        for (int j = 0; j < matrix.length; j++) {
            for (int k = 0; k < matrix.length; k++) {
                System.out.print(matrix[j][k] + " ");
            }
            System.out.println();
        }
    }
}
