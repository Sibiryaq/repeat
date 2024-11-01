package praktikum.Core2.time;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeClass {
    public static void main(String[] args) {
        ZoneId zoneUtc = ZoneId.of("UTC-03:45");

        // запись аналогична ZoneId.of("UTC-03:00");
        ZoneId zoneUtc3 = ZoneId.of("UTC-3");

        // создаём экземпляр местного времени и даты
        LocalDateTime dateTime = LocalDateTime.now();
        // создаём экземпляр временной зоны
        ZoneId zone = ZoneId.of("UTC+3");

        // создаём экземпляр ZonedDateTime
        ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime, zone);
        System.out.println(zonedDateTime);

        ZoneId zoneId = ZoneId.of("Asia/Krasnoyarsk");
        /*
        Europe/Moscow — Москва,
        Asia/Yekaterinburg — Екатеринбург, Пермь,
        https://en.wikipedia.org/wiki/List_of_tz_database_time_zones
         */

        Instant now = Instant.now();

        // сохраняем московское время:
        ZoneId moscowZone = ZoneId.of("Europe/Moscow");
        ZonedDateTime moscowDateTime = ZonedDateTime.ofInstant(now, moscowZone);
    }
}
