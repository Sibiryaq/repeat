package multuthreading.waitAndNotify;

public class Producer implements Runnable {
    Market market;

    Producer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            market.putBread();
        }
    }
}
