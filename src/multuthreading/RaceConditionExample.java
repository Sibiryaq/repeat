package multuthreading;

public class RaceConditionExample {
    static int counter = 0;
    static boolean condition = false;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                if(condition) {
                    counter++;
                }
            }
        });

        Thread thread2 = new Thread( () -> {
            condition = true;
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

        System.out.println(counter);
    }
}
