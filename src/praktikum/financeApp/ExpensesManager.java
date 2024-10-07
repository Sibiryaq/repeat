package praktikum.financeApp;

import java.util.ArrayList;
import java.util.HashMap;

public class ExpensesManager {
    HashMap<String, ArrayList<Double>> expensesByCategories;

    ExpensesManager() {
        expensesByCategories = new HashMap<>();
    }

    double saveExpense(double moneyBeforeSalary, String category, double expense) {
        moneyBeforeSalary = moneyBeforeSalary - expense;
        System.out.println("Значение сохранено! Ваш текущий баланс в рублях: " + moneyBeforeSalary);
        if (expensesByCategories.containsKey(category)) {
            ArrayList<Double> expenses = expensesByCategories.get(category);
            expenses.add(expense);
        } else {
            ArrayList<Double> expenses = new ArrayList<>();
            expenses.add(expense);
            expensesByCategories.put(category, expenses);
        }
        if (moneyBeforeSalary < 1000) {
            System.out.println("На вашем счету осталось совсем немного. Стоит начать экономить!");
        }
        return moneyBeforeSalary;
    }

    void printAllExpensesByCategories() {
        for (String category : expensesByCategories.keySet()) {
            System.out.println(category);
            ArrayList<Double> expenses = expensesByCategories.get(category);
            for (Double expense : expenses) {
                System.out.println(expense);
            }
        }
    }

    double findMaxExpenseInCategory(String category) {
        double maxExpense = 0;
        if (expensesByCategories.containsKey(category)) {
            ArrayList<Double> expenses = expensesByCategories.get(category);
            for (Double expense : expenses) {
                if (expense > maxExpense) {
                    maxExpense = expense;
                }
            }
        } else {
            System.out.println("Такой категории пока нет.");
        }
        return maxExpense;
    }

    void removeAllExpenses() {
        expensesByCategories.clear();
        System.out.println("Траты удалены.");
    }

    double getExpensesSum() {  // Напишите метод для получения суммы всех трат
        double result = 0;
        for (ArrayList<Double> categoryExpenses : expensesByCategories.values()) {
            for (Double expense : categoryExpenses) {
                result += expense;
            }
        }
        return result;
    }

    void removeCategory(String name) {
        expensesByCategories.remove(name); // Напишите метод для удаления категории
    }

    String getMaxCategoryName() {// Напишите метод для получения категории, где размер трат больше всего
        // Используйте эти переменные для сохранения промежуточных значений
        double maxCategorySum = 0;
        String maxCategoryName = "";

        for (String category : expensesByCategories.keySet()) {
            double sum = 0;
            for (double expenses : expensesByCategories.get(category)) {
                sum += expenses;
                if (sum > maxCategorySum) {
                    maxCategorySum = sum;
                    maxCategoryName = category;
                }
            }

        }
        return maxCategoryName;
    }
}