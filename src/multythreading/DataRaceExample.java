package multythreading;

/**
 * Data Race возникат когда два или более потока пытаются читать и записывать одну и ту же переменную
 * без должной синхронизации и по крайней мере один из потоков изменяют переменную.
 * Это может привести к непредсказуемым результатам, из-за того
 * что операции чтения и записи не являются атомарными
 */
public class DataRaceExample {
    static int counter = 0;

    /**
     * synchronized позволяет заблокировать доступ к методу или его части кода, если его
     * УЖЕ использует другой поток
     * Если метод или объект "свободен" поток может с ним работать Если же метод уже используется, поток просто ждёт
     *
     */
    public static synchronized void increment() {
        counter++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new R());
        Thread thread2 = new Thread(new R());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(counter);
    }
}


class R implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            DataRaceExample.increment();
        }
    }
}
