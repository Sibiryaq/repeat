package praktikum.Core1.OOP.Abstract;

public class Toad extends Amphibian{

    protected Toad(){
        super("коричневая");
    }

    @Override
    public void move() {
        System.out.println("Я важно хожу.");
    }
}
