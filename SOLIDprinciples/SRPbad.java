package SOLIDprinciples;

class Employee {
    private String name;
    private String email;
    private double salary;

    public Employee(String name, String email, double salary) {
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    // 1️⃣ Salary calculation + tax logic
    public void calculateSalary() {
        System.out.println("Calculating salary for " + name);
        double tax = salary * 0.10;
        double netSalary = salary - tax;
        System.out.println("Net Salary = " + netSalary);
    }

    // 2️⃣ Database code
    public void saveToDatabase() {
        System.out.println("Connecting to DB and saving employee...");
    }

    // 3️⃣ Payslip (PDF generation)
    public void generatePayslip() {
        System.out.println("Generating PDF Payslip for " + name);
    }

    // 4️⃣ Email sending
    public void sendPayslipEmail() {
        System.out.println("Sending payslip email to " + email);
    }
}

public class SRPbad {
    public static void main(String[] args) {
        Employee e1 = new Employee("User", "user@email.com", 50000);

        e1.calculateSalary();
        e1.saveToDatabase();
        e1.generatePayslip();
        e1.sendPayslipEmail();
    }
}
