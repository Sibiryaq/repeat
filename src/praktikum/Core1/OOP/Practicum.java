package praktikum.Core1.OOP;

public class Practicum {
    public static void main(String[] args) {
        Cappucino cappucino = new Cappucino();
        System.out.println("Объем чашки капучино - " + cappucino.mixAndGetVolume());

        System.out.println(cappucino.espresso);
        System.out.println(cappucino.milk);
        Latte latte = new Latte();
        System.out.println("Объем чашки латте - " + latte.mixAndGetVolume());


    }
}
