package praktikum.Core2.exceptions;

public class Resource2 implements AutoCloseable {

    @Override
    public void close() {
        System.out.println("метод close() для Resource2");
    }
}