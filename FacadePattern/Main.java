package FacadePattern;

class SeatService{
    public boolean checkAvailability(String ItemId){
        System.out.println("Checking availability for :" + ItemId);
        return true ;

    }
}

class PaymentService{
    public boolean makePayment(double amount){
        System.out.println("Processing Payment for " + amount);
        return true ;
    }
}

class NotificationService{
    public void sendConfirmation (String user){
        System.out.println("Sending Confirmation to :" + user);
    }
}

class BookingFacade {

    private SeatService seatService;
    private PaymentService paymentService;
    private NotificationService notificationService;

    public BookingFacade() {
        this.seatService = new SeatService();
        this.paymentService = new PaymentService();
        this.notificationService = new NotificationService();
    }

    public void book(String itemId, String user, double amount) {
        System.out.println("\n--- Booking Request Started ---");

        if (!seatService.checkAvailability(itemId)) {
            System.out.println("Booking failed: Item not available!");
            return;
        }

        if (!paymentService.makePayment(amount)) {
            System.out.println("Booking failed: Payment error!");
            return;
        }

        notificationService.sendConfirmation(user);

        System.out.println("Booking Successful for: " + user);
        System.out.println("--- Booking Completed ---\n");
    }
}


public class Main {
    public static void main(String[] args) {
        BookingFacade bookingSystem = new BookingFacade();
        
        bookingSystem.book("MOVIE-123", "user@mail.com", 350.00);
        bookingSystem.book("TRAIN-987", "example@mail.com", 720.50);
    }
}
