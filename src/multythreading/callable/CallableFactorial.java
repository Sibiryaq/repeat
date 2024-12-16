package multythreading.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Callable интерфейс подобный Runnable но с ключевыми отличиями
 * Callable может возвращать объект, представляющий результат выполнения задачи
 * где V - тип результата (Callable</V>)
 * Также позволяет выбрасывать проверяемые исключения из метода call()
 */
public class CallableFactorial {
    static int factorialResult;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Factorial factorial = new Factorial(5);
        Future<Integer> future = executorService.submit(factorial);
        try{
            System.out.println("Want to take result");
            factorialResult = future.get();
            System.out.println("Result");
        } catch(InterruptedException exception) {
            throw new RuntimeException(exception);
        } catch(ExecutionException exception) {
            System.out.println(exception.getCause());
        } finally {
            executorService.shutdown();
        }
        System.out.println(factorialResult);

        int i = 5;
        i = i++ + ++i;
        System.out.println(i);
    }
}
