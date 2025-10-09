import java.util.*;

abstract class Shape {
    protected double dim1, dim2;

    public Shape(double dim1, double dim2) {
        this.dim1 = dim1;
        this.dim2 = dim2;
    }

    public abstract double area();

    public final void displayInfo(String shapeName) {
        System.out.println("Shape: "+shapeName);
        System.out.println("Area: "+area());
    }
}

interface Colorable {
    String colorDescription();
}

class Rectangle extends Shape implements Colorable {
    private String color;

    public Rectangle(double l, double b, String color) {
        super(l, b);
        this.color = color;
    }

    @Override
    public double area() {
        return dim1 * dim2;
    }

    @Override
    public String colorDescription() {
        return "Rectangle color: " + color;
    }
}

class Triangle extends Shape implements Colorable {
    private String color;

    public Triangle(double b, double h, String color) {
        super(b, h);
        this.color = color;
    }

    @Override
    public double area() {
        return 0.5 * dim1 * dim2;
    }

    @Override
    public String colorDescription() {
        return "Triangle color: " + color;
    }
}


class Circle extends Shape implements Colorable {
    private String color;

    public Circle(double r, String color) {
        super(r, 0);
        this.color = color;
    }

    @Override
    public double area() {
        return 3.14 * dim1 * dim1;
    }

    @Override
    public String colorDescription() {
        return "Circle color: " + color;
    }
}


class InvalidSalaryException extends Exception {
    public InvalidSalaryException(String message) {
        super(message);
    }
}

class Employee {
    protected double baseSalary;

    public Employee(double baseSalary) throws InvalidSalaryException {
        if (baseSalary < 0)
            throw new InvalidSalaryException("Base salary cannot be negative!");
        this.baseSalary = baseSalary;
    }

    public double calculateSalary() {
        return baseSalary;
    }
}

class Manager extends Employee {
    private double bonus;

    public Manager(double baseSalary, double bonus) throws InvalidSalaryException {
        super(baseSalary);
        if (bonus < 0)
            throw new InvalidSalaryException("Bonus cannot be negative!");
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        double total = super.calculateSalary() + bonus;
        return total;
    }
}

// ===============================
// Part 3: Method Overloading with Varargs
// ===============================

class MathOperations {

    // 2 integers
    public int sum(int a, int b) {
        System.out.println("sum(int, int) called");
        return a + b;
    }

    // 3 doubles
    public double sum(double a, double b, double c) {
        System.out.println("sum(double, double, double) called");
        return a + b + c;
    }

    // Variable number of integers
    public int sum(int... nums) {
        System.out.println("sum(int...) called");
        int total = 0;
        for (int n : nums) total += n;
        return total;
    }
}

public class Shapes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        String[] colors = {"Red", "Green", "Blue", "Yellow", "Orange"};
        Shape[] shapes = new Shape[3];

        try {

            System.out.print("Enter length and breadth of rectangle: ");
            double l = sc.nextDouble();
            double b = sc.nextDouble();
            validateInput(l, b);
            shapes[0] = new Rectangle(l, b, colors[rand.nextInt(colors.length)]);

            System.out.print("Enter base and height of triangle: ");
            double base = sc.nextDouble();
            double h = sc.nextDouble();
            validateInput(base, h);
            shapes[1] = new Triangle(base, h, colors[rand.nextInt(colors.length)]);

            System.out.print("Enter radius of circle: ");
            double r = sc.nextDouble();
            validateInput(r);
            shapes[2] = new Circle(r, colors[rand.nextInt(colors.length)]);

            System.out.println("\n--- Shape Information ---");
            for (Shape s : shapes) {
                s.displayInfo(s.getClass().getSimpleName());
                if (s instanceof Colorable)
                    System.out.println(((Colorable) s).colorDescription());
                System.out.println();
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid input type");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }

    private static void validateInput(double... nums) {
        for (double n : nums) {
            if (n <= 0)
                throw new IllegalArgumentException("Dimensions must be positive numbers");
        }
    }

}
