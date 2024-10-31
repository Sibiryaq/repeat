package praktikum.Core2.streams;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        /*
        Операции над стримами:
        промежуточные (intermediate) - изменячют поток, и возвращают обратно stream,
        можно выполнить последовательно несколько

        терминальные (terminal) - конечная операция, вызывается и стрима только 1 раз,
        завершает работу над стримом

        Если создать стрим и указать набор промежуточных операций, но не указать ни одной терминальной
        ничего сделано не будет
         */

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);


        List<Integer> afterStream = numbers.stream().
                collect(Collectors.toList());

    }
}
