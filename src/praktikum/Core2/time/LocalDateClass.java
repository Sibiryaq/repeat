package praktikum.Core2.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static java.util.Calendar.JANUARY;

public class LocalDateClass {
    // Иногда время может понадобиться без даты, и наоборот: в некоторых задачах нужна дата, но не время.

    LocalDate someDate = LocalDate.of(2000, JANUARY, 1);

    // создаём экземпляр LocalDate, в котором будет храниться 32-й день в году
    LocalDate someDate2 = LocalDate.ofYearDay(2000, 32);


    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.now();

        // извлечём время
        LocalTime time = dateTime.toLocalTime();
        System.out.println(time);

        // извлечём дату
        LocalDate date = dateTime.toLocalDate();
        System.out.println(date);
    }

}
