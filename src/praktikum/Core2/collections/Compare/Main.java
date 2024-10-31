package praktikum.Core2.collections.Compare;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Рубашка", 4500, 37));
        items.add(new Item("Носки", 55, 8));
        items.add(new Item("Толстовка", 1399, 74));
        items.add(new Item("Носки", 169, 19));

        System.out.println("До сортировки:");
        System.out.println(items);

        // создаём объект-компаратор по цене
        ItemPriceComparator itemPriceComparator = new ItemPriceComparator();

        // применяем компаратор
        items.sort(itemPriceComparator);

        System.out.println("После сортировки:");
        System.out.println(items);

        ItemPopularityComparator ipc = new ItemPopularityComparator();

        items.sort(ipc);
        System.out.println("После сортировки:");
        System.out.println(items);


        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Банан");
        fruits.add("Апельсин");
        fruits.add("Яблоко");
        fruits.add("Груша");

        fruits.sort(String.CASE_INSENSITIVE_ORDER);
    }

}
