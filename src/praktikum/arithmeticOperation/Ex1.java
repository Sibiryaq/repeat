package praktikum.arithmeticOperation;

public class Ex1 {
    public static void main(String[] args) {
        int a = 36;
        int b = 2;
        a -= b; // равнозначно a = a - b
        a *= b; // равнозначно a = a * b
        a /= b; // равнозначно a = a / b

        int prefix = 20;
        System.out.println(prefix);   // здесь значение равно 20
        System.out.println(++prefix); // значение сначала станет 21, а потом будет напечатано

        int postfix = 10;
        System.out.println(postfix);   // значение равно 10
        System.out.println(postfix++); // сначала будет напечатано 10, потом прибавится единица
        System.out.println(postfix);   // значение postfix теперь равно 11

        int x = 14;
        int y = 20;
        int z = x % y;
        System.out.println(z); // остатток от деления будет 14, т.к. 20 поместится ровно 0 раз

    }
}
