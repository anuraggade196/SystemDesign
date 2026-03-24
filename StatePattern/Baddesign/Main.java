package StatePattern.Baddesign;
class Order{
    private String state ;

    public Order(String state){
        this.state = state ;

    }
    public void nextState(){
        switch (state) {
            case "ORDER_PLACED":
                state = "PREPARING";
                break;
            case "PREPARING":
                state ="OUT_FOR_DELIVERY";
                break;
            case "OUT_FOR_DELIVERY":
                state="DELIVERED";
                break;
              
        }
    }
    public void printState(){
     System.out.println("Current State = " + state);
    }
    public void cancelOrder() {

        if (state.equals("ORDER_PLACED") ||
            state.equals("PREPARING")) {

            state = "CANCELLED";
            System.out.println("Order cancelled");

        } else {

            System.out.println("Cannot cancel now");
        }
    }
}

public class Main {
    public static void main(String args[]){
       Order order = new Order("ORDER_PLACED");

        order.printState();

        order.nextState();
        order.printState();

        order.nextState();
        order.printState();

        order.cancelOrder();   // should not cancel now

        order.nextState();
        order.printState();
    }
    
}
