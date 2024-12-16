package multythreading.deadlock;

public class Thread10 extends Thread{

    @Override
    public void run() {
        System.out.println("T10: Попытка захватить монитор объекта lock1");
        synchronized (DeadLockEx.lock1) {
            System.out.println("T10: Монитор объекта lock1 захвачен");
            System.out.println("Попытка захватить монитор объекта lock2");
            synchronized (DeadLockEx.lock2) {
                System.out.println("Т10: Мониторы объектов lock1 и lock2 захвачены");
            }
        }
    }
}
