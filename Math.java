class MathOperations {

    public int sum(int a, int b) {
        System.out.println("sum(int,int) is called");
        return a + b;
    }
    public double sum(double a, double b, double c) {
        System.out.println("sum(double, double, double) is called");
        return a + b + c;
    }

    public int sum(int... nums) {
        System.out.println("sum(int...) called");
        int total = 0;
        for (int n : nums) total += n;
        return total;
    }
}

public class Math {
    public static void main(String[] args) {
        MathOperations mo = new MathOperations();

        System.out.println("Sum (2 integers): " + mo.sum(5, 10));
        System.out.println("Sum (3 doubles): " + mo.sum(1.2, 2.3, 3.4));
        System.out.println("Sum (varargs): " + mo.sum(1, 2, 3, 4, 5));
    }
}
