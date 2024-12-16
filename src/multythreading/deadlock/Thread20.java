package multythreading.deadlock;

public class Thread20 extends Thread {

    @Override
    public void run() {
        System.out.println("T20: Попытка захватить монитор объекта lock2");
        synchronized (DeadLockEx.lock2) {
            System.out.println("T20: Монитор объекта lock2 захвачен");
            System.out.println("Попытка захватить монитор объекта lock1");
            synchronized (DeadLockEx.lock1) {
                System.out.println("Т20: Мониторы объектов lock1 и lock2 захвачены");
            }
        }
    }
}
