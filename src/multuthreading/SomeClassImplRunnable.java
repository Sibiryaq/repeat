package multuthreading;

public class SomeClassImplRunnable implements Runnable{
    @Override
    public void run() {
        for(int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000); // каждую итерацию, будет ожидание в 1000мс  - 1 сек
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + ": " + i);
            // Thread[#22,Поток номер 1 - создание чисел от 0 до 99: ,10,main]0
            // где #22 номер в ОС, 10 приоритет, main - откуда запущен
        }
    }
}
