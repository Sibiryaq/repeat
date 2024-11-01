package praktikum.Core2.time;

import java.time.LocalDateTime;

public class LocalDateTimeClass {
    public static void main(String[] args) {
        LocalDateTime current = LocalDateTime.now();
        System.out.println(current);
        /*
        Информацию о текущем времени программа берет из устройства, на котором она запущена
        если у кого-то намеренно спешат часы на полчаса, то именно это время и возьмется
         */

        // год, месяц, день, часы, минуты, секунды, наносекунды
        LocalDateTime newMillennium = LocalDateTime.of(2000, 1, 1, 0, 0, 0, 0);
        System.out.println(newMillennium);
        // не передаём секунды и наносекунды
        LocalDateTime alsoNewMillennium = LocalDateTime.of(2000, 1, 1, 0, 0);
        System.out.println(alsoNewMillennium);

        /*
        методы для получения новых экземпляров на основе уже имеющихся значений:

        plusYears(long years)/minusYears(long years)
        plusMonths(long months)/minusMonths(long months)
        plusWeeks(long weeks)/minusWeeks(long weeks)
        plusDays(long days)/minusDays(long days)
        plusHours(long hoursToAdd)/minusHours(long hoursToSubtract)
        plusMinutes(long minutesToAdd)/minusMinutes(long minutesToSubtract)
        plusSeconds(long secondstoAdd)/minusSeconds(long secondsToSubtract)
        plusNanos(long nanosToAdd)/minusNanos(long nanosToSubtract)
         */
    }

}
