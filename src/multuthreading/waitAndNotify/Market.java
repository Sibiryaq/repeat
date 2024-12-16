package multuthreading.waitAndNotify;

public class Market {
    private int breadCount = 0;

    public synchronized void getBread() {
        while(breadCount < 1) {
            try {
                wait();
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
        breadCount--;
        System.out.println("The consumer bought one bread");
        System.out.println("count of bread: " + breadCount);
        notify();
    }

    public synchronized void putBread() {
        while (breadCount >= 5) {
            try {
                wait();
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
        breadCount++;
        System.out.println("Producer put one bread");
        System.out.println("Count of bread: " + breadCount);
        notify();
    }
}
