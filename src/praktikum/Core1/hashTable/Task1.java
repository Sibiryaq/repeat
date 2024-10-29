package praktikum.Core1.hashTable;

import java.util.ArrayList;
import java.util.HashMap;

public class Task1 {
    public static void main(String[] args) {

        HashMap<String, ArrayList<Integer>> stateHolidays = new HashMap<>();
        ArrayList<Integer> january = new ArrayList<>();
        january.add(1);
        january.add(7);
        stateHolidays.put("Январь",january);

        ArrayList<Integer> february = new ArrayList<>();
        february.add(23);
        stateHolidays.put("Февраль", february);

        System.out.println(stateHolidays);

        HashMap<String, Double> orders = new HashMap<>();
        orders.put("Иван И.", 4345.5);
        orders.put("Ольга С.", 76564.43);
        orders.put("Александр Т.", 1234.86);
        orders.put("Александр Р.", 23432.87);
        orders.put("Екатерина О.", 1034753.6);
        orders.put("Ярослав В.", 450.0);


        double sum = 0;
        for (Double order : orders.values()) {
            sum += order;
        }
        System.out.println("Всего было совершено заказов на сумму: " + sum);

        for(String order : orders.keySet()) {
            System.out.println(order);
        }

        if(orders.containsKey("Иван И.")) {
            orders.remove("Иван И.");
        } else {
            System.out.println("Ивана нет");
        }
        System.out.println("Пары K+V но уже без Ивана" + orders);
        System.out.println(orders.get("Иван И.")); // т.к. Ивана нет, то вернет null

        orders.clear();
        System.out.println("Никого" + orders);
    }
}
