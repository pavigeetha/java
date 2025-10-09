
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

public class Employee_ {
    public static void main(String[] args) {
        try {
            Employee emp = new Employee(30000);
            Manager mgr = new Manager(50000, 10000);

            System.out.println("Employee salary: " + emp.calculateSalary());
            System.out.println("Manager salary: " + mgr.calculateSalary());
        } catch (InvalidSalaryException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
