package SOLIDprinciples;

// Small, focused interfaces
interface Printable {
    void print();
}

interface Scannable {
    void scan();
}

interface Faxable {
    void fax();
}

// All in one printer supports all features
class AllInOnePrinter implements Printable, Scannable, Faxable {

    @Override
    public void print() {
        System.out.println("Printing...");
    }

    @Override
    public void scan() {
        System.out.println("Scanning...");
    }

    @Override
    public void fax() {
        System.out.println("Faxing...");
    }
}

// Basic printer supports only printing
class BasicPrinter implements Printable {

    @Override
    public void print() {
        System.out.println("Printing...");
    }
}

public class ISPgood {
    public static void main(String[] args) {

        Printable basic = new BasicPrinter();
        Printable printer = new AllInOnePrinter();
        Scannable scanner = new AllInOnePrinter();

        System.out.println("Basic Printer:");
        basic.print();

        System.out.println("\nAll In One Printer:");
        printer.print();
        scanner.scan();
    }
}
