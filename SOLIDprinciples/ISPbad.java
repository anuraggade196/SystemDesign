package SOLIDprinciples;

interface Machine {
    void print();
    void scan();
    void fax();
}

class AllInOnePrinter implements Machine {

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

class BasicPrinter implements Machine {

    @Override
    public void print() {
        System.out.println("Printing...");
    }

    @Override
    public void scan() {
        throw new UnsupportedOperationException("This feature is not available");
    }

    @Override
    public void fax() {
        throw new UnsupportedOperationException("This feature is not available");
    }
}

public class ISPbad {
    public static void main(String[] args) {

        Machine basic = new BasicPrinter();
        Machine allInOne = new AllInOnePrinter();

        System.out.println("Basic Printer:");
        basic.print();
        try {
            basic.scan();  // LSP & ISP violation → unused method
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nAll In One Printer:");
        allInOne.print();
        allInOne.scan();
        allInOne.fax();
    }
}
