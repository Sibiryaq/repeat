package praktikum.Core2.collections.Set;

import java.util.*;

public class Main {
    private static final Set<String> issuedCards = new HashSet<>();

    public static void main(String[] args) {
        issuedCards.add("3688 2836 2367 0847");
        issuedCards.add("9522 4377 2788 9805");
        issuedCards.add("1278 6724 0988 4714");
        issuedCards.add("9142 7356 9815 9066");
        issuedCards.add("1168 9734 4967 2984");

        String newCard = generateNewCard();

        // проверим, свободен ли этот номер карты
        System.out.println("Номер карты " + newCard +
                " свободен? " + !issuedCards.contains(newCard));
        /*
        для Set contains - O(1) - данные не перебираются, сразу знаем где лежит
        для List - O(n)
        addAll - принимает на вход обьект типа Collection,
        возрашет true - если хотябы один элемент был добавлен
        или false - если все элементы уже содержаться в множестве
         */

        List<String> allNames = new ArrayList<>();
        allNames.add("Марья");
        allNames.add("Пётр");
        allNames.add("Светлана");
        allNames.add("Кристина");
        allNames.add("Иван");
        allNames.add("Макс");
        allNames.add("Светлана");
        allNames.add("Иван");
        allNames.add("Олег");
        allNames.add("Олег");
        allNames.add("Олег");

        Set<String> uniqueNames = new HashSet<>(allNames);
        Set<Integer> example = new HashSet<>(16, 0.75f);
        Set<String> example2 = new LinkedHashSet<>(16, 0.75f);


        System.out.println("Количество имён в списке allNames: " + allNames.size());
        System.out.println("Количество имён в множестве uniqueNames: " + uniqueNames.size());
    }

    public static String generateNewCard() {
        return "9734 3477 3844 3702";
    }
}
