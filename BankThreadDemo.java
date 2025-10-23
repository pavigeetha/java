import java.util.Scanner;

class Bank {
    int balance;

    synchronized void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " trying to withdraw ₹" + amount);
        if (balance < amount) {
            System.out.println("Insufficient balance! Waiting for deposit...");
            try { wait(); } catch (Exception e) {}
        }
        balance -= amount;
        System.out.println("Withdrawal successful! New balance: ₹" + balance);
    }

    synchronized void deposit(int amount) {
        System.out.println(Thread.currentThread().getName() + " depositing ₹" + amount);
        balance += amount;
        System.out.println("Deposit complete! New balance: ₹" + balance);
        notify();
    }
}

public class BankThreadDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        System.out.print("Enter initial balance: ");
        bank.balance = sc.nextInt();

        System.out.print("Enter withdrawal amount: ");
        int withdrawAmt = sc.nextInt();

        System.out.print("Enter deposit amount: ");
        int depositAmt = sc.nextInt();

        Thread t1 = new Thread(() -> bank.withdraw(withdrawAmt), "WithdrawalThread");
        Thread t2 = new Thread(() -> {
            try { Thread.sleep(1000); } catch (Exception e) {}
            bank.deposit(depositAmt);
        }, "DepositThread");

        t1.start();
        t2.start();
    }
}

