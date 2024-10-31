package praktikum.Core2.exceptions;

import java.io.ByteArrayInputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Finally {
    /**
     * блок finally выполнится в любом из этих случаев:
     * если исключение не было
     * после того, как оно было отловлено в блоке catch
     * после того, как исключение произошло, но не было отловлено в catch, т.к. там стоял другой тип
     * кроме тех случаев, если в try были вызваны методы, которые инициируют остановку JVM
     * <p>
     * нужен при взаимодействии с объектами, которые требуют закрытия после завершения работы с ними
     * например Scanner
     *
     * Можно использовать без catch
     */

    public static void main(String[] args) throws NoSuchElementException {
        final Scanner scanner = new Scanner(new ByteArrayInputStream("hello\nworld".getBytes()));
        try {
            System.out.println("Первая линия: " + scanner.nextLine());
            System.out.println("Вторая линия: " + scanner.nextLine());
            // создано только две линии, следующее получение сгенерирует ошибку
            System.out.println("Третья линия: " + scanner.nextLine());
        } catch (NoSuchElementException exception) {
            System.out.println("Ошибка: линии закончились");
        } finally {
            System.out.println("Закрываем сканер");
            scanner.close();
        }


    }



}
