package praktikum.Core2.Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListInterface {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(0);
        integerList.add(1);
        integerList.add(2); // [0, 1 , 2]

        integerList.add(0, 100); // [ 100, 0, 1, 2]
        System.out.println(integerList);
        integerList.add(integerList.size(), 200);
        System.out.println(integerList);
        integerList.addLast(200); // равносильно версии выше [100, 0, 1, 2, 200, 200]
        integerList.remove(0);
        // integerList.remove(200);
        // лучше для хранения не пользоваться Integer,
        // т.к. удалить по значению не получится, будет потыться удалить по индексу,
        // а 200 это уже выход за пределы диапазона

        String[] citiesArray = {"Воронеж", "Южно-Сахалинск", "Иркутск"};
        List<String> cities = Arrays.asList(citiesArray); // получили список из массива


        List<String> cities2 = Arrays.asList("Воронеж", "Южно-Сахалинск", "Иркутск"); // создали список из набор значений
        // Списки полученные при помощи Arrays.asList и List.of считаются неизменяемыми
        // - не поддерживают операции удаления или добавления
        String[] massiveOfCities = cities2.toArray(new String[]{});

    }

}
