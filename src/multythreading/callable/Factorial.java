package multythreading.callable;

import java.util.concurrent.Callable;

public class Factorial implements Callable<Integer> {
    int f;

    public Factorial(int f) {
        this.f = f;
    }

    @Override
    public Integer call() throws Exception {
        if (f <= 0) {
            throw new Exception("Incorrect number");
        }
        int result = 1;
        for (int i = 0; i <= f; i++) {
            result *= i;
            Thread.sleep(1000);
        }
        return result;
    }
}
