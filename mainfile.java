import employee.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.*;

public class mainfile {

    public static void main(String[] args) throws IOException {
    FileWriter fw = new FileWriter("log1.txt", true); // append mode
    PrintWriter logWriter = new PrintWriter(fw, true);
    PrintStream originalOut = System.out;
 // Redirect output to both console and log file
    PrintStream logOut = new PrintStream(new OutputStream() {
        public void write(int b) {
            originalOut.write(b);
            logWriter.write(b);
            }
        }, true);


    System.setOut(logOut);
    Scanner sc = new Scanner(System.in);
    ArrayList<Employee> employeelist = new ArrayList<>();

    System.out.println("Fill Employee Details");
    System.out.println("Enter number of employees:");
    int n = sc.nextInt();
    logWriter.println(n);

    for (int i = 0; i < n; i++){
        System.out.println("-----------------"+"Employee "+(i+1)+"-------------------------");
        System.out.print("\nEmployee type\n1: Programmer\n2: AssistantProfessor\n3: AssociateProfessor\n4: Professor\n");
        System.out.println("Enter type: ");
        int choice = sc.nextInt();
        logWriter.println("Choice: "+choice);
        System.out.println("Enter Name: ");
        String name = sc.next();
        logWriter.println("Name: "+name);
        System.out.println("Enter ID: ");
        int id = sc.nextInt();
        logWriter.println("ID: "+id);
        System.out.println("Enter Address: ");
        String address = sc.next();
        logWriter.println("Address: "+address);
        System.out.println("Enter Mail ID: ");
        String mail = sc.next();
        logWriter.println("MailID: "+mail);
        System.out.println("Enter Mobile No: ");
        String mobile = sc.next();
        logWriter.println("Mobile: "+mobile);
        System.out.println("Enter Basic Pay: ");
        double bpay = sc.nextDouble();
        logWriter.println("BasicPay: "+bpay);

            Employee emp = null;
            switch (choice) {
                case 1:
                    emp = new Programmer(name, id, address, mail, mobile, bpay);
                    break;
                case 2:
                    emp = new AssistantProfessor(name, id, address, mail, mobile, bpay);
                    break;
                case 3:
                    emp = new AssociateProfessor(name, id, address, mail, mobile, bpay);
                    break;
                case 4:
                    emp = new Professor(name, id, address, mail, mobile, bpay);
                    break;
                default:
                    System.out.println("Invalid type. Skipping.");
            }
                employeelist.add(emp);
        }

        System.out.println("\n===== PAY SLIPS =====");
        for (Employee emp : employeelist) {
            emp.paySlip();
            System.out.println("----------------------------");
        }

        logWriter.close();
        sc.close();

    }


    }