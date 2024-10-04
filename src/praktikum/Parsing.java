package praktikum;

public class Parsing {
    public static void main(String[] args) {
        String input = "111";
        Byte z = Byte.parseByte(input);
        Short x = Short.parseShort(input);
        Short q = Short.parseShort("345");
        Integer w = Integer.parseInt("999999");
        Long e = Long.parseLong("1000000000000");
        Float r = Float.parseFloat("12.3");
        Double t = Double.parseDouble("456.789");
        Boolean y =  Boolean.parseBoolean("true");

        String firstNumber = "123.3";
        String secondNumber = "456.6";
        System.out.println(addNumbers(firstNumber, secondNumber));

        long a = 142_858_234;
        long b = 9_123_456_678L;
        long maximum = Long.max(a, b);
        System.out.println("Максимальное значение - " + maximum);

        double c = 0.00175764;
        double d = 0.00138534;

        double minimum = Double.min(c, d);
        System.out.println("Минимальное значение - " + minimum);

        byte b1 = 10;
        byte b2 = 20;
        printMaxOfBytes(b1, b2);

        short sh1 = -5;
        short sh2 = 5;
        printMinOfShorts(sh1, sh2);
    }

    static Float addNumbers(String firstNumber, String secondNumber) {
        return Float.parseFloat(firstNumber) + Float.parseFloat(secondNumber);
    }

    static void printMaxOfBytes(byte b1, byte b2) {
        int max_of_bytes = Integer.max((int)b1, (int)b2);
        System.out.println(max_of_bytes);
    }

    static void printMinOfShorts(short sh1, short sh2) {
        int min_of_shorts = Integer.min((int)sh1, (int)sh2);
        System.out.println(min_of_shorts);
    }
}
