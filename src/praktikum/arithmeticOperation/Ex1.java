package praktikum.arithmeticOperation;

public class Ex1 {
    public static void main(String[] args) {

        /*
        Первыми отработают операторы префиксного инкремента и декремента — ++a и --a;
        Затем — операторы умножения, деления и остатка от деления: *, / и %;
        Третьи на очереди — операторы сложения и вычитания + и -;
        Последними выполняются операции с постфиксным инкрементом и декрементом: a++ и a--.
         */
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

        int d = 120;
        int c = 43;
        d /= c;
        System.out.println(d); // будет 2, а не 2.79 , т.к. d типа int

        double f = 120;
        int g = 43;
        f /= g;
        System.out.println(f); // Теперь получим нужный результат 2.79

    }
}
