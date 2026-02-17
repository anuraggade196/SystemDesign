package AdaptorPattern.GoodDesign;

interface PaymentGateway{
    void pay(String OrderID , double Amount);
}

class PayU implements PaymentGateway{
    @Override
    public void pay(String OrderID , double Amount){
        System.out.println("PayU Payment done for order ID "
                + OrderID + " of amount " + Amount);
    }
}

// Third-party API (cannot modify)
class RazorPayAPI{
    void makePayment(String InvoiceID , double INRPrice){
        System.out.println("RazorPay Payment Done for "
                + InvoiceID + " For a price of " + INRPrice);
    }
}

// Adapter
class RazorPayAdapter implements PaymentGateway {

    private RazorPayAPI razorPayAPI;

    public RazorPayAdapter() {
        razorPayAPI = new RazorPayAPI();
    }

    @Override
    public void pay(String orderID, double amount) {
        razorPayAPI.makePayment(orderID, amount);
    }
}

class PaymentService {

    private PaymentGateway paymentGateway;

    // Dependency Injection (better design)
    PaymentService(PaymentGateway paymentGateway){
        this.paymentGateway = paymentGateway;
    }

    public void processPayment(String orderID , double amount){
        paymentGateway.pay(orderID , amount);
    }
}

public class Main {

    public static void main(String[] args) {

        // Using PayU
        PaymentService payuService =
                new PaymentService(new PayU());
        payuService.processPayment("ORD101", 5000);

        // Using RazorPay via Adapter
        PaymentService razorService =
                new PaymentService(new RazorPayAdapter());
        razorService.processPayment("ORD102", 8000);
    }
}
