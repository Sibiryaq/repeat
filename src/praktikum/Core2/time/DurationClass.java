package praktikum.Core2.time;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;

import static java.time.Month.JUNE;

public class DurationClass {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        // напишите здесь свою дату рождения с точностью до часов и минут
        int yearOfBirth = 1994;
        Month monthOfBirth = JUNE;
        int dayOfMonth = 25;
        int hourOfBirth = 9;
        int minuteOfBirth = 0;
        LocalDateTime birthday = LocalDateTime.of(yearOfBirth, monthOfBirth, dayOfMonth, hourOfBirth, minuteOfBirth);

        Duration duration = Duration.between(birthday, now);

        System.out.println("На момент запуска кода вы прожили " + duration.getSeconds()
                + " секунд и " + duration.getNano() + " наносекунд.");

    }
}
