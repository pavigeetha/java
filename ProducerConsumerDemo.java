class Stock {
    int item;
    boolean available = false;

    synchronized void getStock() {
        while (!available) {
            try { wait(); } catch (Exception e) {}
        }
        System.out.println("Consumer consumed item: " + item);
        available = false;
        notify();
    }

    synchronized void addStock(int item) {
        while (available) {
            try { wait(); } catch (Exception e) {}
        }
        this.item = item;
        System.out.println("Producer produced item: " + item);
        available = true;
        notify();
    }
}

class Producer implements Runnable {
    Stock s;
    Producer(Stock s) { this.s = s; }
    public void run() {
        for (int i = 1; i <= 5; i++) {
            s.addStock(i);
            try { Thread.sleep(500); } catch (Exception e) {}
        }
    }
}

class Consumer implements Runnable {
    Stock s;
    Consumer(Stock s) { this.s = s; }
    public void run() {
        for (int i = 1; i <= 5; i++) {
            s.getStock();
            try { Thread.sleep(500); } catch (Exception e) {}
        }
    }
}

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        Stock s = new Stock();
        new Thread(new Producer(s)).start();
        new Thread(new Consumer(s)).start();
    }
}
