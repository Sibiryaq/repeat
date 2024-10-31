package praktikum.Core2.collections.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListInterface {
    public static void main(String[] args) {
        int size = 0; // текущий размер коллекции
        int capacity = 10; //изначальная вместимость если нет мест, то *1,5
        // можно указать другой изначальный размер new ArrayList<>(100);
        // если финальный размер списка известен
        // add O(1) но иногда когда размер заканчивается нужно пересоздавать список O(n), если по индексу, то элементы могут перемещаться вправо
        // remove 0(1) если по индексу, то элементы могут перемещаться влево
        // get O(1)

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
        for(String elem :massiveOfCities) {
            System.out.println(elem);
        }


    }

}
