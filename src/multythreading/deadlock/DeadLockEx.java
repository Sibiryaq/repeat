package multythreading.deadlock;

/**
 * DeadLock - ситуация когда 2 и более потоков залочены навсегда, ожидают друг друга и ничего не делают
 * Во избежании, порядок синхронизации на объектах у разных потоков должен быть одинаковым
 */
public class DeadLockEx {
    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread10 thread10 = new Thread10();
        Thread20 thread20 = new Thread20();
        thread10.start();
        thread20.start();
    }

}
