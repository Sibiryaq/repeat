package praktikum.Core2.time;

import java.time.LocalTime;

public class LocalTimeClass {
    //Иногда время может понадобиться без даты, и наоборот: в некоторых задачах нужна дата, но не время.
    LocalTime someTime = LocalTime.of(12, 15, 35, 999);
    LocalTime anotherTime = LocalTime.of(12, 15);


}
