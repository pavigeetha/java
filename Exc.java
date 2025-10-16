import java.io.*;
import java.util.*;

class InvalidArraySizeException extends Exception {
    public InvalidArraySizeException(String message) {
        super(message);
    }
}

class UnderageException extends RuntimeException {
    public UnderageException(String message) {
        super(message);
    }
}

class UnrealisticAgeException extends Exception {
    public UnrealisticAgeException(String message) {
        super(message);
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class Exc {

    static void dynamicArrayDemo() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("\nEnter array size: ");
            int size = sc.nextInt();

            if (size <= 0) {
                throw new InvalidArraySizeException("Array size must be positive and greater than zero.");
            }

            int[] arr = new int[size];
            System.out.println("Array of size " + size + " created successfully!");
        } 
        catch (InvalidArraySizeException e) {
            System.out.println("Custom Exception: " + e.getMessage());
        } 
        catch (InputMismatchException e) {
            System.out.println("Input Error: Please enter an integer.");
        } 
        finally {
            System.out.println("Array size validation complete(finally block) .\n");
            sc.close();
        }
    }

    static void checkVotingEligibility(int age) throws UnrealisticAgeException {
        if (age < 18) {
            throw new UnderageException("You must be at least 18 to vote!");
        } else if (age > 120) {
            throw new UnrealisticAgeException("Age entered is unrealistic (>120).");
        } else {
            System.out.println("Eligible to vote!");
        }
    }

    static void nestedFileReadDemo() {
        System.out.println("Nested Try-Catch File Reading Demo:");
        File file = new File("numbers.txt");
        Scanner sc = null;
        int sum = 0;

        try {
            sc = new Scanner(file);

            try {
                while (sc.hasNext()) {
                    String token = sc.next();
                    try {
                        int num = Integer.parseInt(token);
                        sum += num;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number skipped: " + token);
                    }
                }
                System.out.println("Sum of valid numbers: " + sum);
            } 
            catch (Exception e) {
                System.out.println("Error while reading file: " + e.getMessage());
            }

        } 
        catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } 
        finally {
            if (sc != null) sc.close();
            System.out.println("File closed safely.\n");
        }
    }

    static double balance = 5000;

    static void transfer(double amount) throws InsufficientBalanceException {
        try {
            if (amount > balance) {
                throw new InsufficientBalanceException("Transfer failed: Insufficient balance");
            }
            balance -= amount;
            System.out.println("Transfer of Rs." + amount + " successful; Remaining balance: " + balance);
            return;
        } 
        finally {
            try (FileWriter log = new FileWriter("transaction_log.txt", true)) {
                log.write("Attempted transfer: Rs." + amount + "\n");
            } catch (IOException e) {
                System.out.println("Error writing log: " + e.getMessage());
            }
            System.out.println("Transaction attempt logged (finally block).\n");
        }
    }

    public static void main(String[] args) {
    
        dynamicArrayDemo();

        System.out.println("Voting Age Validation Demo:");
        int[] testAges = {15, 25, 130};

        for (int age : testAges) {
            try {
                System.out.println("Checking age: " + age);
                checkVotingEligibility(age);
            } 
            catch (UnderageException e) {
                System.out.println("Unchecked Exception: " + e.getMessage());
            } 
            catch (UnrealisticAgeException e) {
                System.out.println("Checked Exception: " + e.getMessage());
            } 
            finally {
                System.out.println("Validation completed for age: " + age + "\n");
            }
        }

        nestedFileReadDemo();

        System.out.println("Transaction Simulation Demo:");
        try {
            transfer(8000);
        } 
        catch (InsufficientBalanceException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        try {
            transfer(3000);
        } 
        catch (InsufficientBalanceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
