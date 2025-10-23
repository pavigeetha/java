
class WeatherThread extends Thread {
    public void run() {
        System.out.println("Today is hot, humid and sunny.");
    }
}

class HiRunnable implements Runnable {
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("HI");
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

class AiRunnable implements Runnable {
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("AI");
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

public class MultiThreading {
    public static void main(String[] args) {
        System.out.println("=== Threads using Thread class ===");
        WeatherThread t1 = new WeatherThread();
        WeatherThread t2 = new WeatherThread();
        t1.start();
        t2.start();

        try { Thread.sleep(1000); } catch (Exception e) {}

        System.out.println("\n=== Threads using Runnable interface ===");
        Thread hi = new Thread(new HiRunnable());
        Thread ai = new Thread(new AiRunnable());
        hi.start();
        ai.start();
    }
}