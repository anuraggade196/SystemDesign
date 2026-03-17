package Strategy.BadDesign;
class PaymentProcess{
    public void pay(String type){
        if(type.equals("CARD")){
            System.out.println("Payment is done using Card");
        }
        else if(type.equals("UPI")){
            System.out.println("Payment is done using UPI");
        }
        else if(type.equals("PAYPAL")){
            System.out.println("Payment is done using Paypal");
        }
    }

}
public class Main {

    public static void main(String args[]){
        PaymentProcess payment = new PaymentProcess();
        payment.pay("CARD");
    }
    
}
