import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

abstract class Shape {
    protected double dim1, dim2;

    public Shape(double dim1, double dim2) {
        this.dim1 = dim1;
        this.dim2 = dim2;
    }

    public abstract double area();

    public final void displayInfo(String shapeName, PrintWriter log) {
        System.out.println("Shape: "+shapeName+"\nArea: " + area());
        log.println("Shape: "+shapeName+"\nArea: " + area());
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
            throw new InvalidSalaryException("Base salary cannot be negative");
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

class MathOperations {

    public int sum(int a, int b, PrintWriter log) {
        System.out.println("Sum(int,int) is called");
        log.println("Sum(int,int) is called");
        return a + b;
    }
    public double sum(double a, double b, double c,PrintWriter log) {
        System.out.println("sum(double, double, double) is called");
        log.println("Sum(double, double, double) is called");
        return a + b + c;
    }

    public int sum(PrintWriter log,int... nums) {
        System.out.println("sum(int...) called");
        log.println("Sum(int...) is called");
        int total = 0;
        for (int n : nums) total += n;
        return total;
    }
}


public class Shapes {

    public static void main(String[] args) throws IOException {

        
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        String[] colors = {"Red", "Green", "Blue", "Yellow", "Orange"};
        Shape[] shapes = new Shape[3];

        FileWriter fw = new FileWriter("shapes.txt", true);
        PrintWriter log = new PrintWriter(fw, true);

        System.out.println("---------------------------");
        log.println("---------------------------");

        try {

            System.out.print("\nEnter length of the rectangle: ");
            double l = sc.nextDouble();
            System.out.print("Enter breadth of the rectangle: ");
            double b = sc.nextDouble();
            log.println("\nEnter length of the rectangle: "+l+"\nEnter breadth of the rectangle: "+b);
            
            if (l<=0 || b<=0){
                throw new IllegalArgumentException("Dimensions must be positive numbers");
            }

            shapes[0] = new Rectangle(l, b, colors[rand.nextInt(colors.length)]);



            System.out.print("\nEnter base of the triangle: ");
            double bs = sc.nextDouble();
            System.out.print("Enter height of the triangle: ");
            double h = sc.nextDouble();
            log.println("\nEnter base of the triangle: "+bs+"\nEnter height of the triangle: "+b);

            if (bs<=0 || h<=0){
                throw new IllegalArgumentException("Dimensions must be positive numbers");
            }
            
            shapes[1] = new Triangle(bs, h, colors[rand.nextInt(colors.length)]);

            System.out.print("\nEnter radius of circle: ");
            double r = sc.nextDouble();
            log.println("\nEnter radius of circle: "+r);

            if (r<=0){
                throw new IllegalArgumentException("Radius must be positive");
            }
            
            shapes[2] = new Circle(r, colors[rand.nextInt(colors.length)]);


            System.out.println("\n--- Shape Information ---\n");
            log.println("\n--- Shape Information ---\n");
            for (Shape s : shapes) {
                s.displayInfo(s.getClass().getSimpleName(),log);
                String desc = ((Colorable) s).colorDescription();
                System.out.println(desc);
                log.println(desc);
                System.out.print("\n");

            }





            System.out.print("\nEnter base salary of employee: ");
            double e_bs = sc.nextDouble();
            log.println("Enter base salary of employee: "+e_bs);
            Employee emp = new Employee(e_bs);

            System.out.print("Enter base salary of Manager: ");
            double m_bs = sc.nextDouble();
            log.println("Enter base salary of Manager: "+m_bs);

            System.out.print("Enter Manager bonus: ");
            double m_bonus = sc.nextDouble();
            log.println("Enter Manager bonus: "+m_bonus);
            
            Manager mgr = new Manager(m_bs, m_bonus);

            System.out.println("\nEmployee salary: " + emp.calculateSalary());
            log.println("Employee salary: " + emp.calculateSalary());
            System.out.println("Manager salary: " + mgr.calculateSalary());
            log.println("Manager salary: " + mgr.calculateSalary());





            MathOperations mo = new MathOperations();
            System.out.print("\nEnter how many numbers you want to sum: ");
            int count = sc.nextInt();
            log.println("\nEnter how many numbers you want to sum: " + count);

            if (count == 2) {
                System.out.print("Enter numbers: ");
                int a = sc.nextInt();
                int a1 = sc.nextInt();
                int result = mo.sum(a, a1, log);
                log.println("Enter numbers: "+a+" "+a1);
                System.out.println("Sum = " + result);
                log.println("Sum = " + result);
            } else if (count == 3) {
                System.out.print("Enter numbers: ");
                double x = sc.nextDouble();
                double y = sc.nextDouble();
                double z = sc.nextDouble();
                log.println("Enter numbers: "+x+" "+y+" "+z);
                double result = mo.sum(x, y, z, log);
                System.out.println("Sum = " + result);
                log.println("Sum = " + result);
            } else if (count > 3) {
                int[] nums = new int[count];
                System.out.println("Enter " + count + " integers:");
                log.println("Enter " + count + " integers:");
                for (int i = 0; i < count; i++) {
                    nums[i] = sc.nextInt();
                    log.print(nums[i]+" ");
                }
                log.print("\n");
                int result = mo.sum(log, nums);
                System.out.println("Sum = " + result);
                log.println("Sum = " + result);
            } else {
                System.out.println("Invalid count for sum operation.");
                log.println("Invalid count for sum operation.");
            }





        } catch (InputMismatchException e) {
            System.out.println("Invalid input type");
            log.println("Invalid input type");


        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            log.println("Error: " + e.getMessage());


        }catch (InvalidSalaryException e) {
            System.out.println("Error: " + e.getMessage());
            log.println("Error: " + e.getMessage());

        System.out.println("---------------------------");
        log.println("---------------------------");

        sc.close();
    }


}
}