package praktikum.accessModifier;

import java.util.Arrays;

public class Main {
    String aphorism = "Не рискуя, мы рискуем в сто раз больше.";
    public static void main(String[] args) {
        int[] buses = {123, 29, 500, 738};
        Arrays.sort(buses);
        System.out.println(buses);
        System.out.println(Arrays.toString(buses));


        /**
         * Статический метод может обращаться только к статическим
         * переменным и методам
         */
       // System.out.println(aphorism);
        //Non-static field aphorism cannot be referenced from a static context
    }
}
