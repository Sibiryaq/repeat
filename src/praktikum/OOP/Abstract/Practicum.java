package praktikum.OOP.Abstract;

public class Practicum {
    public static void main(String[] args) {
        Frog frog = new Frog();
        System.out.println("Привет! Я - "+ frog.getColor() + "  лягушка.");
        frog.move();

        Toad toad = new Toad();
        System.out.println("Привет! Я - "+ toad.getColor() + " жаба.");
        toad.move();

    }
}
