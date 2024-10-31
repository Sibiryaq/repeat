package praktikum.Core2;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Unicode {
    public static void main(String[] args) {
        /**
         * Кодировка по умолчанию - глобальный параметр, нельзя ее установить только для одних классов
         * java -Dfile.encoding=UTF-8 Unicode
         */
        System.out.println((char) 89);
        System.out.println("\u041F\u0440\u0430\u043A\u0442\u0438\u043A\u0443\u043C");
        System.out.println(Charset.defaultCharset().displayName());

        // преобразование из строки в массив байтов
        String s = "Обычная строка.";
        byte[] buffer = s.getBytes(StandardCharsets.UTF_8);





    }
}
