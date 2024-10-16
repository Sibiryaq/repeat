package praktikum.OOP.bot;

public class Bot {
    String name;

    public Bot() {
        System.out.println("Чат бот создан");
    }

    public Bot(String name) {
        this(); // Вызвали конструктор без параметров
        this.name = name;
        System.out.println("Вас приветствует " + name);
    }
}
