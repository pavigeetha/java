package employee;

public class AssistantProfessor extends Employee {

    double bpay;
    String des;

     public AssistantProfessor(String name, int id, String address, String mail, String mobile, double bpay) {
        super(name, id, address, mail, mobile);
        this.bpay = bpay;
        this.des = "Assistant Professor";
    }

    @Override
    public void paySlip() {
        double da = 0.10 * bpay;
        double hra = 0.10 * bpay;
        double pf = 0.12 * bpay;
      
        double gross_salary = bpay + da + hra;
        double netsalary = gross_salary - pf;

        display();
        System.out.println("Designation: " + des);
        System.out.println("Basic Pay  : " + String.format("%.2f",bpay));
        System.out.println("Gross Salary: " + String.format("%.2f",gross_salary));
        System.out.println("Net Salary  : " + String.format("%.2f",netsalary));
    }
}