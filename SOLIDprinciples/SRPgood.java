package SOLIDprinciples;

// ✔ Emp class: stores data only
class Emp {
    private String name;
    private String email;
    private double salary;

    public Emp(String name, String email, double salary) {
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public double getSalary() { return salary; }
}


// ✔ SalaryCalculator: salary calculation only
class SalaryCalculator {
    public double calculate(Emp emp) {
        double tax = emp.getSalary() * 0.10;
        return emp.getSalary() - tax;
    }
}


// ✔ EmployeeRepository: database operations only
class EmployeeRepository {
    public void save(Emp emp) {
        System.out.println("Saving " + emp.getName() + " to database...");
    }
}


// ✔ PayslipGenerator: payslip generation only
class PayslipGenerator {
    public void generate(Emp emp) {
        System.out.println("Generating payslip PDF for " + emp.getName());
    }
}


// ✔ EmailService: sending emails only
class EmailService {
    public void sendPayslip(Emp emp) {
        System.out.println("Sending payslip email to " + emp.getEmail());
    }
}


// MAIN CLASS
public class SRPgood {
    public static void main(String[] args) {

        Emp e1 = new Emp("User", "user@email.com", 50000);

        SalaryCalculator calc = new SalaryCalculator();
        EmployeeRepository repo = new EmployeeRepository();
        PayslipGenerator payslip = new PayslipGenerator();
        EmailService email = new EmailService();

        double finalSalary = calc.calculate(e1);
        System.out.println("Final Salary = " + finalSalary);

        repo.save(e1);
        payslip.generate(e1);
        email.sendPayslip(e1);
    }
}
