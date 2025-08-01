import CurrencyConverter.CurrencyConverter;
import DistanceConverter.DistanceConverter;
import TimeConverter.TimeConverter;


import java.io.*;
import java.util.Scanner;


public class Converter {
    
    public static void main(String[] args) throws IOException {

        FileWriter fw = new FileWriter("log.txt", true); // append mode
        PrintWriter logWriter = new PrintWriter(fw, true);
        PrintStream originalOut = System.out;

        // Redirect output to both console and log file
        PrintStream logOut = new PrintStream(new OutputStream() {
            public void write(int b) {
                originalOut.write(b);
                logWriter.write(b);
            }
        });
        System.setOut(logOut);

        Scanner sc = new Scanner(System.in);

        CurrencyConverter currency = new CurrencyConverter();
        DistanceConverter distance = new DistanceConverter();
        TimeConverter time = new TimeConverter();

        while (true){

            System.out.println("\n-----------------------------------------");
            System.out.println("Converter Menu");
            System.out.println("1. Currency Converter");
            System.out.println("2. Distance Converter");
            System.out.println("3. Time Converter");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 4) break;

            switch(choice){

                case 1:
                System.out.println("\nCurrency Conversion Options:");
                    System.out.println("1. Dollar to INR");
                    System.out.println("2. INR to Dollar");
                    System.out.println("3. Euro to INR");
                    System.out.println("4. INR to Euro");
                    System.out.println("5. Yen to INR");
                    System.out.println("6. INR to Yen");
                    System.out.print("Enter option: ");
                    System.out.flush();
                    int c = sc.nextInt();
                    logWriter.println(c);
                    System.out.print("Enter amount: ");
                    System.out.flush();
                    double amount = sc.nextDouble();
                    logWriter.println(amount);

                    switch (c) {

                        case 1: 
                        System.out.println("Result: " + currency.dollartoinr(amount)); 
                        break;

                        case 2: 
                        System.out.println("Result: " + currency.inrtodollar(amount)); 
                        break;

                        case 3: 
                        System.out.println("Result: " + currency.eurotoinr(amount)); 
                        break;

                        case 4: 
                        System.out.println("Result: " + currency.inrtoeuro(amount)); 
                        break;

                        case 5: 
                        System.out.println("Result: " + currency.yentoinr(amount)); 
                        break;

                        case 6: 
                        System.out.println("Result: " + currency.inrtoyen(amount)); 
                        break;

                        default: 
                        System.out.println("Invalid option");
                    }
                    break;

                
                case 2:
                    System.out.println("\nDistance Conversion Options:");
                    System.out.println("1. Meter to KM");
                    System.out.println("2. KM to Meter");
                    System.out.println("3. Miles to KM");
                    System.out.println("4. KM to Miles");
                    System.out.print("Enter option: ");
                    System.out.flush();
                    int d = sc.nextInt();
                    logWriter.println(d);
                    System.out.print("Enter distance: ");
                    System.out.flush();
                    double dist = sc.nextDouble();
                    logWriter.println(dist);

                    switch (d) {
                        case 1: 
                        System.out.println("Result: " + distance.metertokm(dist)); 
                        break;
                        
                        case 2: 
                        System.out.println("Result: " + distance.kmtometer(dist)); 
                        break;
                        
                        case 3: 
                        System.out.println("Result: " + distance.milestokm(dist)); 
                        break;
                        
                        case 4: 
                        System.out.println("Result: " + distance.kmtomiles(dist)); 
                        break;
                        
                        default: 
                        System.out.println("Invalid option");
                    }
                    break;

                case 3:
                    System.out.println("\nTime Conversion Options:");
                    System.out.println("1. Hours to Minutes");
                    System.out.println("2. Minutes to Hours");
                    System.out.println("3. Hours to Seconds");
                    System.out.println("4. Seconds to Hours");
                    System.out.print("Enter option: ");
                    System.out.flush();
                    int t = sc.nextInt();
                    logWriter.println(t);
                    System.out.print("Enter time: ");
                    System.out.flush();
                    double time_ = sc.nextDouble();
                    logWriter.println(time_);

                    switch (t) {
                        case 1: 
                        System.out.println("Result: " + time.hourstominutes(time_)); 
                        break;
                        
                        case 2: 
                        System.out.println("Result: " + time.minutestohours(time_)); 
                        break;
                        
                        case 3: 
                        System.out.println("Result: " + time.hourstoseconds(time_)); 
                        break;
                        
                        case 4: 
                        System.out.println("Result: " + time.secondstohours(time_)); 
                        break;
                        
                        default: 
                        System.out.println("Invalid option");
                    }
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            
            }
        
        }
        System.out.println("Exited.");
        sc.close();
        logWriter.close();
    }
}
