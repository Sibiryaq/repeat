package praktikum.constants;

import java.util.Scanner;

public class Practicum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Пожалуйста, введите сумму перевода в рублях.");
        double amount = Double.parseDouble(scanner.next());

        boolean isValid = TransactionValidator.isValidAmount(amount);
        if (isValid)
            System.out.println("Спасибо! Ваш перевод на сумму " + amount + " р. успешно выполнен.");
    }
}