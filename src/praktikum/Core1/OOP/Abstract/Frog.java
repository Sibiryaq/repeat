package praktikum.Core1.OOP.Abstract;

public class Frog extends Amphibian{

    protected Frog(){
        super("зеленая");
    }

    @Override
    public void move() {
        System.out.println("Я передвигаюсь по суше прыжками.");
    }
}
