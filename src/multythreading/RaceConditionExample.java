package multythreading;

import java.util.concurrent.CountDownLatch;

public class RaceConditionExample {
    static int counter = 0;
    //static boolean condition = false;

    static CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            try {
                latch.await();
                for (int i = 0; i < 100; i++) {
                    counter++;
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        });

        Thread thread2 = new Thread(() -> {
            latch.countDown();  //уменьшает счётчик latch, сигнализирую потоку thread1 выполнение
        });

        thread1.start();
        thread2.start();
        /*
        Состояние гонки возникает, когда один и тот же ресурс используется несколькими
        потока одновременно, и в зависимости от порядка действий каждого потока может
        быть несколько возможных результатов
         */

        thread1.join(); // заставим main подождать выполнения наших потоков
        thread2.join();

        System.out.println(counter); // всегда будет выводить 100
    }
}
