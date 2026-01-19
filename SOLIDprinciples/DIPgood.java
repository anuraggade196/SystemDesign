// ✅ GOOD DIP DESIGN

package SOLIDprinciples;

// 1️⃣ Abstraction
interface PaymentGateway {
    void processPayment();
}

// 2️⃣ Low-level implementations depend on abstraction
class Razorpay implements PaymentGateway {
    @Override
    public void processPayment() {
        System.out.println("Payment processed through Razorpay");
    }
}

class Stripe implements PaymentGateway {
    @Override
    public void processPayment() {
        System.out.println("Payment processed through Stripe");
    }
}

// 3️⃣ High-level module depends on abstraction, not concrete class
class PaymentService {

    private PaymentGateway gateway;

    // Dependency Injection
    public PaymentService(PaymentGateway gateway) {
        this.gateway = gateway;
    }

    public void makePayment() {
        gateway.processPayment();
    }
}

public class DIPgood {
    public static void main(String[] args) {

        // Use Razorpay
        PaymentService service1 = new PaymentService(new Razorpay());
        service1.makePayment();

        // Switch to Stripe (no code change in PaymentService)
        PaymentService service2 = new PaymentService(new Stripe());
        service2.makePayment();
    }
}
