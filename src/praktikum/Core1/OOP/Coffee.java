package praktikum.Core1.OOP;

public class Coffee {
    protected double espresso;
    protected double milk;

    public Coffee() {
        espresso = 50.0;
        milk = 250.0;
    }

    public Coffee(double newEspresso, double newMilk) {
        espresso = newEspresso;
        milk = newMilk;
    }

    public double mixAndGetVolume() {
        return espresso + milk;
    }

}
