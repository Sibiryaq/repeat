package multythreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock starvation (голодание)
 * ситуация, когда менее приоритетные потоко ждут долгое время или все время для того, чтобы могли запуститься
 * В этом примере, потоки с низким проритетом могут пострадать от голодания,
 * потому что поток с высоким приоритетом постоянно захватывает блокировку
 * и не дает шанса низкоприоритеттным потокам работать с ресурсом
 *
 * Cпособы устранения - удаление приоритетов, временные блокировки, квоты на работу, использование fair locks
 */
public class LockStarvation {
    private static final Lock fairLock = new ReentrantLock(true);

    public static void main(String[] args) {
        final Object lock = new Object();

        Thread highPriorityThread = new Thread( () -> {
            synchronized (lock) {
                while (true) { // бесконечная работа
                    System.out.println("High priority thread working");
                }
            }
        });
        highPriorityThread.setPriority(Thread.MAX_PRIORITY);

        for (int i = 0; i < 10; i++) {
            Thread lowPriorityThread = new Thread( () -> {
                synchronized (lock) {
                    System.out.println("Low priority thread working");
                }
            });
            lowPriorityThread.setPriority(Thread.MIN_PRIORITY);
            lowPriorityThread.start();
        }

        highPriorityThread.start();
    }
}
