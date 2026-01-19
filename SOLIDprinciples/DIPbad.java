// ❌ BAD DIP DESIGN

package SOLIDprinciples;

// Low-level classes
class Razorpay {
    public void processPayment() {
        System.out.println("Payment processed through Razorpay");
    }
}

class Stripe {
    public void processPayment() {
        System.out.println("Payment processed through Stripe");
    }
}


class PaymentService {

    private Razorpay razorpay = new Razorpay();
    private Stripe stripe = new Stripe();

    public void makePayment(String method) {

        if (method.equals("razorpay")) {
            razorpay.processPayment();   // tightly coupled ❌
        }
        else if (method.equals("stripe")) {
            stripe.processPayment();     // tightly coupled ❌
        }
        else {
            System.out.println("Invalid payment method");
        }
    }
}

public class DIPbad {
    public static void main(String[] args) {

        PaymentService service = new PaymentService();

        service.makePayment("razorpay");
        service.makePayment("stripe");
    }
}
