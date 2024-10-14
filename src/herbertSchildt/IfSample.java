package herbertSchildt;

public class IfSample {
    public static void main(String[] args) {
        int x, y;
        x = 10;
        y = 20;
        if (x < y) System.out.println("x < y");
        x *= 2;
        if (x == y) System.out.println("Теперь x == y");
        x *= 2;
        if (x > y) System.out.println("Теперь x > y");
    }
}
