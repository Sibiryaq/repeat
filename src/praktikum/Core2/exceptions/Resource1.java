package praktikum.Core2.exceptions;

public class Resource1 implements AutoCloseable {

    @Override
    public void close() {
        System.out.println("метод close() для Resource1");
    }
}