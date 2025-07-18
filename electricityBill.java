import java.util.*;

class electricityBill{

    public static class customerDetails{

        int consumerNumber;
        String consumerName;
        int previousReading;
        int currentReading;
        String connectionType;

        }

    public static customerDetails inputhandler(){

        System.out.println("\nEnter Customer Details\n");
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int number = sc.nextInt();

        System.out.print("Enter name: ");
        String name = sc.next();

        System.out.print("Enter previous reading: ");
        int prevReading = sc.nextInt();

        System.out.print("Enter current reading: ");
        int currentReading = sc.nextInt();

        System.out.print("Enter type of connection: ");
        String type = sc.next();

        customerDetails details = new customerDetails();

        details.consumerNumber = number;
        details.consumerName = name;
        details.previousReading = prevReading;
        details.currentReading = currentReading;
        details.connectionType = type;

        sc.close();
        return details;

    }

    public static Double bill(String type, int currentreading, int prevreading){

        Double bill = 0.00; 
        int reading = currentreading-prevreading;
        
        System.out.println("Units consumed: "+ reading);

        if (type.equals("domestic")){
            if (reading<=100){
                bill = reading*1.00;
            }

            else if (reading <= 200 && reading >= 101){
                bill = reading*2.5;
            }

            else if (reading <= 500 && reading >= 201){
                bill = reading*4.00;

            }

            else {
                bill = reading*6.00;
                
            }
        }

        else if (type.equals("commercial")){
            if (reading<=100){
                bill = reading*2.00;
            }

            else if (reading <= 200 && reading >= 101){
                bill = reading*4.5;
            }

            else if (reading <= 500 && reading >= 201){
                bill = reading*6.00;

            }

            else {
                bill = reading*7.00;
                
            }
        }

        return bill;
    }

    public static void main(String[] args) {
        
        customerDetails details = inputhandler();

        int creading = details.currentReading;
        int preading = details.previousReading;
        String Type = details.connectionType;

        System.out.println("\n ------------- Electricity Bill ----------------\n");
        System.out.println("Consumer name: "+details.consumerName);
        System.out.println("Consumer number: "+details.consumerNumber);
        System.out.println("Previous reading: "+details.previousReading);
        System.out.println("Current reading: "+details.currentReading);
        System.out.println("Type of connection : "+details.connectionType+"\n");
        
        double finalBill = bill(Type,creading,preading);

        System.out.println("Amount: "+finalBill+"\n");



    }



}

