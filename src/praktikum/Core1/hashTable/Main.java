package praktikum.Core1.hashTable;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        HashMap<String, String> officeTool = new HashMap<>(16, 0.75f);

        officeTool.put("S234", "Большой степлер");
        officeTool.put("P342", "Чёрно-белый принтер из коридора");
        officeTool.put("N845", "Острые ножницы");
        System.out.println(officeTool.get("S234")); // Получили степлер по ключу S234
        for (String tool : officeTool.values()) {
            System.out.println(tool);
        }

        HashMap<String, String> statesCapitals = new HashMap<>();
        statesCapitals.put("Канада", "Торонто");
        statesCapitals.put("Ирак", "Багдад");
        statesCapitals.put("Австрия", "Вена");

        statesCapitals.put("Канада", "Оттава"); //Предыдущее значение перезапишется
        System.out.println(statesCapitals);

        HashMap<String, ArrayList<Integer>> orders = new HashMap<>();

        ArrayList<Integer> ordersNum = new ArrayList<>(); // Создаём новый список
        ordersNum.add(1);
        ordersNum.add(5);
        ordersNum.add(6);
        orders.put("Иван И.", ordersNum); // Добавили имя клиента и список его заказов

        /* Для нового клиента новый список.
           Можно не создавать ещё одну переменную, а переиспользовать имеющуюся.*/
        ordersNum = new ArrayList<>();
        ordersNum.add(2);
        ordersNum.add(4);
        ordersNum.add(3);
        orders.put("Ольга С.", ordersNum);

        // Заводим переменную для списка заказов конкретного клиента
        ArrayList<Integer> customerOrders = orders.get("Ольга С.");
        // Печатаем номера заказов конкретного клиента
        for (int orderNum : customerOrders) {
            System.out.println("Заказ № " + orderNum);
        }

    }
}
