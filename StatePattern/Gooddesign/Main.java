package StatePattern.Gooddesign;

class OrderContext{
    private OrderState state;
    public OrderContext(){
        state = new OrderPlacedState();
        System.out.println("Initial state: " + state.getStateName());


    }
    public void setState(OrderState state){
        this.state= state;

    }
    public void next(){
        state.next(this);
        System.out.println("Current state: " + state.getStateName());

    }
    public void cancel() {
        state.cancel(this);
        System.out.println("Current state: " + state.getStateName());
    }
    
}
interface OrderState{
    void next(OrderContext context);
    void cancel(OrderContext context);
    String getStateName();
}
class OrderPlacedState implements OrderState{
    public void next (OrderContext context){
        context.setState(new PreparingState());
         System.out.println("Order is being prepared");

        
    }
    public void cancel (OrderContext context){
        context.setState(new CancelledState());
        System.out.println("Order cancelled");
    }
     public String getStateName() {
        return "ORDER_PLACED";
    }

}
class PreparingState implements OrderState {

    public void next(OrderContext context) {
        context.setState(new OutForDeliveryState());
        System.out.println("Order out for delivery");
    }

    public void cancel(OrderContext context) {
        context.setState(new CancelledState());
        System.out.println("Order cancelled while preparing");
    }

    public String getStateName() {
        return "PREPARING";
    }
}
class OutForDeliveryState implements OrderState {

    public void next(OrderContext context) {
        context.setState(new DeliveredState());
        System.out.println("Order delivered");
    }

    public void cancel(OrderContext context) {
        System.out.println("Cannot cancel now");
    }

    public String getStateName() {
        return "OUT_FOR_DELIVERY";
    }
}
class DeliveredState implements OrderState {

    public void next(OrderContext context) {
        System.out.println("Already delivered");
    }

    public void cancel(OrderContext context) {
        System.out.println("Cannot cancel delivered order");
    }

    public String getStateName() {
        return "DELIVERED";
    }
}
class CancelledState implements OrderState {

    public void next(OrderContext context) {
        System.out.println("Order cancelled, no next state");
    }

    public void cancel(OrderContext context) {
        System.out.println("Already cancelled");
    }

    public String getStateName() {
        return "CANCELLED";
    }
}

public class Main {
     public static void main(String[] args) {

        OrderContext order = new OrderContext();

        order.next();   // preparing
        order.next();   // out for delivery
        order.cancel(); // cannot cancel
        order.next();   // delivered
    }
    
}
