package SOLIDprinciples;

class PaymentProcessor {

    public void creditCardPaymentProcessor() {
        System.out.println("Payment is done using Credit Card");
    }

    public void paypalPaymentProcessor() {
        System.out.println("Payment is done using PayPal");
    }
}

class CheckoutService {
    public void processPayment(String paymentType) {

        PaymentProcessor processor = new PaymentProcessor();

        if ("CreditCard".equals(paymentType)) {
            processor.creditCardPaymentProcessor();
        } else if ("PayPal".equals(paymentType)) {
            processor.paypalPaymentProcessor();
        } else {
            System.out.println("Invalid payment method");
        }
    }
}

public class OCPbad {
    public static void main(String[] args) {
        CheckoutService checkout = new CheckoutService();
        checkout.processPayment("CreditCard");
        checkout.processPayment("PayPal");
    }
}
