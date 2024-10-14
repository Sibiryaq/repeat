package herbertSchildt;

public class DynInt {
    public static void main(String[] args) {
        double a = 3.0, b = 4.0;
        double c = Math.sqrt(a * a + b * b); // sqrt - квадратный корень агрумента
        System.out.println("Длина гипотенузы равна : " + c);

        double[] massive = {1.0, 2.0, 3.0};
        double sum = 0;
        for(int i = 0; i < massive.length; i++) {
            sum += massive[i];
        }
        System.out.println("Среднеем число в массиве " + sum / massive.length);

        int[] z = new int[2];
        int z2 [] = new int[3]; // тоже можно
    }
}
