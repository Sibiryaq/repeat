package praktikum.Core2.string;

public class StringClass {
    public static void main(String[] args) {
        String myString = "Привет!"; // создание строки через строковый литерал string literal
    /*
    При создании строк с помощью литерала они попадают в - ПУЛ СТРОК
    Если строка уже находится в пуле и вы пытаетесь создать строку с таким же значением
    то она не будет создаваться во второй раз, вместо этого вернется ссылка на уже существующую

    Строки, которые создаются через new НЕ попадают в пул
    Строки нужно сравнивать между собой через equals()
    */

        String one = "привет"; // строка попала в пул
        String two = "привет"; // вместо создания новой строки берётся ссылка на уже существующую
        String three = new String("привет"); // создаётся новый объект

        System.out.println(one == two); // вернёт true
        System.out.println(one == three); // вернёт false
        System.out.println(one.equals(two)); // вернёт true
        System.out.println(one.equals(three)); // вернёт true
        String blankString = "      ";
        System.out.println("Строка пустая? " + blankString.isEmpty()); //false т.к. пробелы тоже символы
        System.out.println("Строка пустая? " + blankString.isBlank());
        System.out.println("Строка пустая? " + blankString.trim().isEmpty());
        // true, т.к. удалены были пробелы
        // вначале и вконце и осталось 0 символов
        String text = "Привет, я Java!";
        System.out.println(text.toUpperCase()); // выведет "ПРИВЕТ, Я JAVA!"
        System.out.println(text.toLowerCase()); // выведет "привет, я java!"



    }
}
