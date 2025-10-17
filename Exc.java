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

    static void dynamicArrayDemo(Scanner sc,PrintWriter log) {
        try {
            System.out.print("\nEnter array size: ");
            int size = sc.nextInt();

            if (size <= 0) {
                throw new InvalidArraySizeException("Array size must be positive and greater than zero.");
            }

            int[] arr = new int[size];
            System.out.println("Array of size " + size + " created successfully!");
            log.println("Array of size " + size + " created successfully!");
        } 
        catch (InvalidArraySizeException e) {
            System.out.println("Custom Exception: " + e.getMessage());
            log.println("Custom Exception: \" + e.getMessage()");
        } 
        catch (InputMismatchException e) {
            System.out.println("Input Error: Please enter an integer.");
            log.println("Input Error: Please enter an integer.");
        } 
        finally {
            System.out.println("Array size validation complete(finally block) .\n");
            log.println("Array size validation complete(finally block)\n");
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

    static void nestedFileReadDemo(PrintWriter log) {
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
                        log.println("Invalid number skipped: " + token);
                    }
                }
                System.out.println("Sum of valid numbers: " + sum);
                log.println("Sum of valid numbers: " + sum);
            } 
            catch (Exception e) {
                System.out.println("Error while reading file: " + e.getMessage());
                log.println("Error while reading file: " + e.getMessage());
            }

        } 
        catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
            log.println("File not found: " + e.getMessage());
        } 
        finally {
            if (sc != null) sc.close();
            System.out.println("File closed safely.\n");
        }
    }

    static void transfer(double amount, PrintWriter log, double balance) throws InsufficientBalanceException {
        try {
            if (amount >= balance) {
                throw new InsufficientBalanceException("Transfer failed: Insufficient balance");
            }
            balance -= amount;
            System.out.println("Transfer of Rs." + amount + " successful; Remaining balance: " + balance);
            return;
        } 
        finally {
            log.println("Attempted transfer of amount "+amount);
        }
    }

    public static void main(String[] args) throws IOException {

        FileWriter fw = new FileWriter("Exceptions.txt", true);
        PrintWriter log = new PrintWriter(fw, true);

        Scanner sc = new Scanner(System.in);
    
        dynamicArrayDemo(sc,log);

        System.out.println("Voting Age Validation Demo:");
        System.out.print("Enter the number of ages to be checked: ");
        int s = sc.nextInt();
        int[] testAges = new int[s];
        int a;

        System.out.print("Enter the ages: ");
        for (int i = 0; i<s; i++){
            a = sc.nextInt();
            testAges[i] = a;
        }

        for (int age : testAges) {
            try {
                System.out.println("Checking age: " + age);
                log.println("Checking age: " + age);
                checkVotingEligibility(age);
            } 
            catch (UnderageException e) {
                System.out.println("Exception: " + e.getMessage());
                log.println("Exception: " + e.getMessage());
            } 
            catch (UnrealisticAgeException e) {
                System.out.println("Exception: " + e.getMessage());
                log.println("Exception: " + e.getMessage());
            } 
            finally {
                System.out.println("Validation completed for age: " + age + "\n");
            }
        }

        nestedFileReadDemo(log);

        System.out.println("Simple Transaction:");
        System.out.print("Enter balance: ");
        double balance = sc.nextInt();
        System.out.print("Enter the number of transfer amounts to be checked: ");
        int si = sc.nextInt();
        double[] TransferAmount = new double[s];
        double t;

        System.out.print("Enter the amounts: ");
        for (int i = 0; i<s; i++){
            t = sc.nextInt();
            TransferAmount[i] = t;
        }

        for (double i : TransferAmount){

        
            try {
                System.out.println("Transfer amount: "+i);
                transfer(i, log, balance);
            } 
            catch (InsufficientBalanceException e) {
                System.out.println("Exception: " + e.getMessage());
                log.println("Exception: " + e.getMessage());
            }
    }
    }
}
