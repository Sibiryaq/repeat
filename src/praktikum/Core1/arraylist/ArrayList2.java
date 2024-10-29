package praktikum.Core1.arraylist;

import java.util.ArrayList;
import java.util.List;

public class ArrayList2 {
    public static void main(String[] args) {

        List<Double> expenses = new ArrayList<>();
        expenses.add(12.0);
        expenses.add(12.0);
        expenses.add(13.0);
        expenses.add(14.0);

        expenses.remove(13.0);
        System.out.println(expenses);

        if(expenses.contains(13.0)){
            System.out.println("Вы точно удалил 13?");
        }

        boolean isExp = expenses.contains(16.0);
        if (!isExp) {
            expenses.add(16.0);
            System.out.println("Теперь список другой: " + expenses);
        } else {
            System.out.println("16 уже есть");
        }

        expenses.clear();
        System.out.println(expenses);


        if (expenses.isEmpty()) {
            System.out.println("Список пуст");
        }

    }
}
