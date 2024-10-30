package praktikum.Core2.string;

public class StringBuilderClass {
    public static void main(String[] args) {
        StringBuilder example = new StringBuilder();
        example.append("Привет, "); // добавляет подстроку в конец StringBuilder
        example.append("билдер!");
        System.out.println(example);

        String asString = example.toString(); // сделали изменяемую строку неизменяемой
        System.out.println(asString);

        StringBuilder builder = new StringBuilder("Hillo, world!");
        builder.replace(1,2, "e");
        builder.replace(7,13, "java!");

        System.out.println(builder.toString());// выведет строку "Hello, java!"
        builder.reverse();
        System.out.println(builder); //!avaj ,olleH

        System.out.println(isPalindrome("Молебен о коне белом"));

    }

    static boolean isPalindrome(String str) {
        String noSpaceStr = str.replace(" ", "").toLowerCase();
        StringBuilder sb = new StringBuilder(noSpaceStr);
        return sb.reverse().toString().equals(noSpaceStr);
    }

}
