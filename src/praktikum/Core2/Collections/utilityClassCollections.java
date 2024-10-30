package praktikum.Core2.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class utilityClassCollections {
    public static void main(String[] args) {
        final List<String> emptyList = Collections.emptyList();
        final List<String> singletonList = Collections.singletonList("Привет, мир!");
        final List<String> nCopiesList = Collections.nCopies(5, "Java");

        System.out.println(emptyList);
        System.out.println(singletonList);
        System.out.println(nCopiesList);
///////////////////////////////////// Замена всех элементов списка /////////////////////////////////
        List<Long> listOfLongs = new ArrayList<>();
        listOfLongs.add(157478403L);
        listOfLongs.add(2450033L);
        listOfLongs.add(32039458858604L);

        System.out.println(listOfLongs);

        Collections.fill(listOfLongs, 5555555L);
        System.out.println(listOfLongs);

//////////////////////////////////////Копирование элементов одного списка в другой/////////////////
        List<Long> listOfSmallLongs = new ArrayList<>();
        listOfSmallLongs.add(1L);
        listOfSmallLongs.add(2L);
        listOfSmallLongs.add(3L);

        List<Long> listOfBigLongs = new ArrayList<>();
        listOfBigLongs.add(10000000000L);
        listOfBigLongs.add(20000000000L);
        listOfBigLongs.add(30000000000L);

        System.out.println(listOfSmallLongs);
        System.out.println(listOfBigLongs);

        Collections.copy(listOfSmallLongs, listOfBigLongs);

        System.out.println(listOfSmallLongs);
        System.out.println(listOfBigLongs);
/////////////////////////////////////// Сортировка через Collections //////////////////////////
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Банан");
        fruits.add("Апельсин");
        fruits.add("Яблоко");
        fruits.add("Груша");

        System.out.println(fruits);

        Collections.sort(fruits, String.CASE_INSENSITIVE_ORDER);

        System.out.println(fruits);
    }
}
