package dmdev;

/**
 * Дано целое  число. Определить явл-ся ли последняя цифра - 3
 */
public class Task2 {
    public static void main(String[] args) {
        int value = 123124;
        if (value % 10 == 3) {
            System.out.println("Последняя цифра 3");
        }
    }
}
