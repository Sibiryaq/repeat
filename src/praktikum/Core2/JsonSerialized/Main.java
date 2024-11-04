package praktikum.Core2.JsonSerialized;

import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        Owner owner = new Owner("Sasha", "Tolstikov");
        Dog dog = new Dog("Пёс", owner, 2);

        Gson gson = new Gson(); //создали объект gson
        String jsonString = gson.toJson(dog); // вызвали метод toJson и передали туда объект для сериализации

        System.out.println(jsonString);

        String jsonString2 = "{\"name\":\"Тузик\",\"owner\":{\"name\":\"Игорь\",\"surname\":\"Петров\"},\"age\":3}";
        Dog dog2 = gson.fromJson(jsonString2, Dog.class);
        System.out.println(dog2);


    }
}
