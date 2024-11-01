package praktikum.Core2.time;

import java.time.Instant;

public class InstantClass {
    public static void main(String[] args) {
        Instant currentTimestamp = Instant.now();
        System.out.println(currentTimestamp); // 2024-11-01T14:18:29.633016800Z
        long milliseconds = currentTimestamp.toEpochMilli();
        System.out.println("Количество миллисекунд прошедших с unix-эпохи " + milliseconds);

        Instant satelliteLaunchFromSec = Instant.ofEpochSecond(-386310686L); // передаём количество секунд с запуска спутника до Unix-эпохи
        Instant satelliteLaunchFromMillis = Instant.ofEpochMilli(-386310686000L); // или делаем то же самое в миллисекундах

        System.out.println(satelliteLaunchFromSec + " — время запуска, заданное через секунды.");
        System.out.println(satelliteLaunchFromMillis + " — время запуска, заданное через миллисекунды.");

        System.out.println(Instant.MIN); // диапазон дат, который можно хранить в экземпляре класса
        System.out.println(Instant.MAX);

        long seconds = 180;

        Instant currentMoment = Instant.now();
        System.out.println("Сейчас " + currentMoment);
        Instant futureMoment = currentMoment.plusSeconds(seconds);
        System.out.println("А через " + seconds + " секунд будет " + futureMoment);

        // isAfter(Instant otherInstant)
        // isBefore(Instant otherInstant)
        // equals(Object otherInstant)

    }
}
