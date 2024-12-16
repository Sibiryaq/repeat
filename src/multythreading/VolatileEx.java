package multythreading;

public class VolatileEx extends Thread {
    /**
     * volatile - обозначает, что переменная хранится в основной памяти (RAM/ОЗУ)
     * используется тольк тогда, когда лишь один потом может изменить значение этой переменной,
     * а остальные - только читать
     * <p>
     * Не решает проблему атомарности
     */
    volatile boolean b = true;

    @Override
    public void run() {
        long counter = 0;

        while (b) {
            counter++;
        }
        System.out.println("Loop os finished. Counter = " + counter);
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileEx threadVol = new VolatileEx();
        threadVol.start();
        Thread.sleep(3000);
        System.out.println("Через 3 секунды вставай!");
        threadVol.b = false;
        threadVol.join();
        System.out.println("Программа окончена");
    }
}
