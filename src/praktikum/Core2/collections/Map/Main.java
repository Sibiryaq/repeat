package praktikum.Core2.collections.Map;

import java.time.LocalDate;
import java.util.*;

public class Main {
    private static Map<Integer, User> users = new HashMap<>();

    public static void main(String[] args) {
        int initialCapacity = 16; // x2 если мало места
        float loadFactor = 0.75f;
        /*
        Если при добавлении новой записи окажется,
        что такой ключ в хеш-таблице уже есть,
        то соответствующее ему значение будет перезаписано.

        Чтобы получить значение по ключу, нужно вызвать метод getTaskById(Object key)
        если в хеш-таблице по запрошенному ключу значения нет, то метод вернёт null

        getOrDefault(Object key, V defaultValue)
        этот метод часто используют для защиты от NullPointerException.
        В случае если искомого ключа (Object key) в хеш-таблице нет,
        вернётся значение по умолчанию (англ. default)
         */

        Map<LocalDate, List<String>> incomingGoods = new HashMap<>();

        incomingGoods.put(LocalDate.of(2021, 9, 17), List.of("Бананы"));
        incomingGoods.put(LocalDate.of(2021, 9, 18), List.of("Яблоки", "Апельсины"));
        incomingGoods.put(LocalDate.of(2021, 9, 23), List.of("Груши"));
        System.out.println("Поступления на склад: " + incomingGoods);

        Map<String, String> films = new LinkedHashMap<>(); // хранит порядок добавления
        films.put("Титаник", "Джеймс Кэмерон");
        films.put("Гарри Поттер и философский камень", "Крис Коламбус");
        films.put("Хакеры", "Иэн Софтли");
        films.put("Терминатор", "Джеймс Кэмерон");

        for (String film : films.keySet()) {
            System.out.println(film);
        }

        Map<String, String> tree = new TreeMap<>(films);
        // можно передать компаратор чтобы определить порядок сортировки

        Comparator<User> userComparator = new Comparator<>() {
            @Override
            public int compare(User user1, User user2) {
                return user1.userId - user2.userId;
            }
        };


        for (int i = 1; i <= 1_000_000L; i++) {
            users.put(i, new User(i, "Имя " + i));
        }

        final long startTime = System.nanoTime();
        User user = findUser(378_366);
        final long endTime = System.nanoTime();

        System.out.println("Найден пользователь: " + users.get(378_366));
        System.out.println("Поиск занял " + (endTime - startTime) + " наносекунд.");


    }

    private static User findUser(int userId) {
        return users.get(userId);
    }


}
