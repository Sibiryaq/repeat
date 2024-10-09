package alishev;

public class Arrays {
    public static void main(String[] args) {
        int number = 10; // примитвный тип данных
        int[] numbers = new int[5]; //ссылается на массив, с индексами 0, 1, 2, 3, 4

        System.out.println(numbers[2]); // 0 в каждой ячейке, т.к. не добавили ничего

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i;
            System.out.print(numbers[i] + " ");
        }

        int[] x = {1, 2, 3, 5, 6, 7}; // другой вариант инициализации, размер массива нельзя изменить после инициализации

        int[] newMassive = new int[10];
        for(int j = 0; j < numbers.length; j++) {
            for (int k = 0; k < numbers.length; k++) {
                newMassive[j] = numbers[j];
            }
        }

        System.out.println();
        for(int z :newMassive) {
            System.out.print(z + " ");
        }

    }
}
