package Strategy.GoodDesign;

interface PaymentStrategy{
    void pay(int amount);
}
class CardPayment implements PaymentStrategy{
    public void pay(int amount){
        System.out.println("Paid by card " + amount);
    }
}

class UPIPayment implements PaymentStrategy{
    public void pay(int amount){
        System.out.println("Paid by UPI " + amount);
    }
}

class PaymentService{
    private PaymentStrategy strategy ;

    PaymentService(PaymentStrategy strategy){
        this.strategy =strategy;
    }
    public void setStategy(PaymentStrategy strategy){
        this.strategy = strategy;
    }
    public void pay(int amount){
        strategy.pay(amount);
    }


}

public class Main {
    public static void main(String args[]){
        PaymentService payment = new PaymentService(new CardPayment() );
        payment.pay(100);
        payment.setStategy(new UPIPayment());
        payment.pay(344);
    }
    
}
