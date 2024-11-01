package praktikum.Core2.UnitTest.test;

import java.util.List;
import java.util.Random;

public class OvercomplicatedCookieFactory {
    private int cookiesCreated = 0;
    private final List<String> positiveTexts;
    private final List<String> negativeTexts;
    private final boolean isPositive;

    // Класс Random используется, чтобы возвращать случайное предсказание из списка.
    private final Random rnd = new Random();

    public OvercomplicatedCookieFactory(List<String> positiveTexts,
                                        List<String> negativeTexts, boolean isPositive) {
        this.positiveTexts = positiveTexts;
        this.negativeTexts = negativeTexts;
        this.isPositive = isPositive;
    }

    // Печём печеньку!
    public String bakeFortuneCookie() {
        StringBuilder cookieBuilder = new StringBuilder();

        // Увеличиваем счётчик печенек:
        this.incrementNumberOfCookiesCreated();

        // Возвращаем хорошее или плохое предсказание:
        if (isPositive) {
            cookieBuilder.append(randomPositive());
        } else {
            cookieBuilder.append(randomNegative());
        }

        // Преобразовываем результат в строку:
        return cookieBuilder.toString();
    }

    // Возвращаем количество испечённых печенек:
    public int getCookiesCreated() {
        return this.cookiesCreated;
    }

    // Обнуляем счётчик созданных печенек:
    public void resetCookiesCreated() {
        this.cookiesCreated = 0;
    }

    // Увеличиваем счётчик испечённых печенек:
    private void incrementNumberOfCookiesCreated() {
        this.cookiesCreated++;
    }

    // Выбираем произвольное предсказание из списка позитивных:
    private String randomPositive() {
        // Получаем целое случайное число от нуля до максимального размера массива - 1.
        int randomIndex = rnd.nextInt(positiveTexts.size());
        return positiveTexts.get(randomIndex);
    }

    // Выбираем произвольное предсказание из списка негативных:
    private String randomNegative() {
        // Получаем целое случайное число от нуля до максимального размера массива - 1.
        int randomIndex = rnd.nextInt(negativeTexts.size());
        return negativeTexts.get(randomIndex);
    }
}