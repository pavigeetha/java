package employee;

public class Employee {

    String Emp_name;
    int Emp_id;
    String Address;
    String Mail_id;
    String Mobile_no;

    public Employee(String name, int id, String address, String mail, String mobile) {
        this.Emp_name = name;
        this.Emp_id = id;
        this.Address = address;
        this.Mail_id = mail;
        this.Mobile_no = mobile;

    }

    public void paySlip() {
        System.out.println("----- Employee Pay Slip -----");
        System.out.println("Name: " + Emp_name);
        System.out.println("ID: " + Emp_id);
    }

    public void display() {
        System.out.println("Employee Details");
        System.out.println("Name: " + Emp_name);
        System.out.println("ID: " + Emp_id);
        System.out.println("Address: " + Address);
        System.out.println("Mail ID: " + Mail_id);
        System.out.println("Mobile No: " + Mobile_no);
    }

    
}
