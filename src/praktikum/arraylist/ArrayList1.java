package praktikum.arraylist;

import java.util.ArrayList;
import java.util.List;

public class ArrayList1 {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList();
        list.addFirst(1);
        list.add(0,2); // при добавлении старые элементы смещаются влево
        System.out.println(list);  // 2, 1

        List<Double> expenses = new ArrayList<>();
        expenses.add(100.0);
        expenses.add(200.0);
        System.out.println("Длина массива expenses : " + expenses.size());
        System.out.println(expenses.getFirst());
        System.out.println(expenses.get(1));

        for (int i = 0; i < expenses.size(); i++) {
            System.out.println("Текущий элемент : "+ expenses.get(i));
        }

        for(Double x : expenses) {
            System.out.println("Текущий элемент : " + x);
        }

        ArrayList<List<Double>> matrix = new ArrayList();
        matrix.add(expenses);
        System.out.println(matrix);



    }
}
