package praktikum.Core2.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class TryWithResources {
    public static void main(String[] args) throws IOException {
        try (Reader fileReader = new FileReader("file.txt")) {
            // что-то делаем с потоком
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } // метод close() будет вызван автоматически, когда программа выйдет из блока try-with-resources


        try (Resource1 resource1 = new Resource1(); Resource2 resource2 = new Resource2()) {
            System.out.println("внутри блока try");
        }
    }
}
