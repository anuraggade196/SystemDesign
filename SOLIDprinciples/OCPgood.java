package SOLIDprinciples;

// 1️⃣ Abstraction
interface PaymentMethod {
    void pay(double amount);
}

// 2️⃣ Credit Card Payment Implementation
class CreditCardPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Payment of " + amount + " done using Credit Card");
    }
}

// 3️⃣ PayPal Payment Implementation
class PayPalPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Payment of " + amount + " done using PayPal");
    }
}

// 4️⃣ Checkout Service (Closed for modification)
class CheckoutServicegood {
    public void processPayment(PaymentMethod paymentMethod, double amount) {
        paymentMethod.pay(amount);
    }
}

// 5️⃣ Main Class
public class OCPgood {
    public static void main(String[] args) {

        CheckoutServicegood checkout = new CheckoutServicegood();

        PaymentMethod creditCard = new CreditCardPayment();
        PaymentMethod paypal = new PayPalPayment();

        checkout.processPayment(creditCard, 100.00);
        checkout.processPayment(paypal, 200.00);
    }
}
