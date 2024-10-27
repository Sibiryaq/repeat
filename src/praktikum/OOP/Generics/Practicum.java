package praktikum.OOP.Generics;

public class Practicum {
    public static void main(String[] args) {
        GeneralClass<String> stringObject = new GeneralClass<>();
        stringObject.element = "Привет";

        GeneralClass<Double> doubleObject = new GeneralClass<>();
        doubleObject.element = 100.0;


        Pair<Integer, String> pair = new Pair<>(10, "Десять");
        pair.print();
        Integer x = pair.getKey();
        String y = pair.getValue();
    }
}
