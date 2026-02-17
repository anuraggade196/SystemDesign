package AdaptorPattern.BadDesign;

interface PaymentGateway{
    void pay(String OrderID , double Amount);
}

class PayU implements PaymentGateway{
    @Override
    public void pay(String OrderID , double Amount){
        System.out.println("Payment is done for order ID "
                + OrderID + " of amount " + Amount);
    }
}

class PaymentService {

    private PaymentGateway paymentGateway;

    PaymentService(String paymentGatewayType){

        if(paymentGatewayType.equalsIgnoreCase("PayU")){
            paymentGateway = new PayU();
        }
        else{
            throw new IllegalArgumentException("Invalid Payment Gateway");
        }
    }

    public void processPayment(String orderID , double amount){
        paymentGateway.pay(orderID , amount);
    }
}

public class Main {

    public static void main(String[] args) {

        PaymentService service = new PaymentService("PayU");

        service.processPayment("ORD101", 5000);
    }
}
