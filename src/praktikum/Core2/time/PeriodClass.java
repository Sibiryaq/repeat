package praktikum.Core2.time;

import java.time.LocalDate;
import java.time.Period;

import static java.util.Calendar.JUNE;

public class PeriodClass {
    public static void main(String[] args) {
       /*
        Используется для вычисления срока между двумя датами. В экземпляре класса есть три поля:
        продолжительность в
        годах getYears(),
        месяцах getMonths(),
        днях getDays().
        */
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(1994, JUNE, 25);

        Period age = Period.between(birthday, today);
        System.out.println("Ваш возраст:");
        System.out.println("Лет: " + age.getYears());
        System.out.println("Месяцев: " + age.getMonths());
        System.out.println("Дней: " + age.getDays());

        // промежуток длиной 100 лет, 10 месяцев, 1 день
        Period longTime = Period.of(100, 10, 1);
    }
}
