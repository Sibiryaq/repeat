package praktikum.Core2.time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterClass {
    /*
    dd — день,
    MM — месяц,
    yyyy — год,
    HH — час,
    mm — минуты,
    ss — секунды,
    SSS — дробная часть секунд.
     */
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Было: " + now);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:mm");
        String formatDateTime = now.format(formatter);
        System.out.println("Стало: " + formatDateTime);



        LocalDateTime dateTime = LocalDateTime.parse("2021-12-21T21:21:21");
        System.out.println(dateTime);

        LocalDateTime anotherDateTime = LocalDateTime.parse("22.02.2022, 22:22", DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:mm"));
        System.out.println(anotherDateTime);

        System.out.println(dateTime.isAfter(anotherDateTime));
    }

}
