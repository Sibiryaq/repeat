package multythreading;

/**
 * Планировщик потоков - управляется JVM и зависчит от реализации JVM и операционной системы, на которой она запущена
 * <p>
 * Жизненный цикл потока -
 * NEW -new Thread() - создан, но не запущен
 * RUNNABLE - start() - готов к выполнению, ждет планировщика
 * RUNNING run - выполняется
 * WAITING sleep(), wait() - блокирован, ждет окончания
 * DEAD/TERMINATED end of execution - завершен
 */
public class GenerateThread {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new SomeClassImplRunnable());
        thread1.setName("Поток номер 1 - создание чисел от 0 до 99: ");
        System.out.println(thread1.getName());
        thread1.setPriority(10); //default 5, можно установить от 1 до 10
        System.out.println("У потока 1 приоритет : " + thread1.getPriority());
        thread1.start(); // thread .start() happens before thread .run()
    }
}
