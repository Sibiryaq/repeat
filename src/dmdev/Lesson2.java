package dmdev;

public class Lesson2 {
    public static void main(String[] args) {
        int value = 25;
        System.out.println(value);

        double value2 = 78.00;
        System.out.println(value2);

        final char testValue = 'A';
        System.out.println(testValue);

        //testValue = 'B'; //Нельзя, из-за final выше
        System.out.println(testValue);

    }
}
