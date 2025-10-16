import java.util.Random;

class NumberGenerator extends Thread {
    int num;
    Random rand = new Random();

    public void run() {
        while (true) {
            num = rand.nextInt(100);
            System.out.println("\nGenerated Number: " + num);

            if (num % 2 == 0) {
                new Square(num).start();
            } else {
                new Cube(num).start();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Generator Interrupted");
            }
        }
    }
}

class Square extends Thread {
    int num;

    Square(int n) {
        num = n;
    }

    public void run() {
        System.out.println("Square of " + num + " = " + (num * num));
    }
}

class Cube extends Thread {
    int num;

    Cube(int n) {
        num = n;
    }

    public void run() {
        System.out.println("Cube of " + num + " = " + (num * num * num));
    }
}

public class MultiThreadExample {
    public static void main(String[] args) {
        NumberGenerator t = new NumberGenerator();
        t.start();
    }
}
