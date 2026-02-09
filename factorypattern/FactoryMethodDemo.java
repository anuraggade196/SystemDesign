package FactoryPattern;

/**
 * FACTORY METHOD PATTERN
 * 
 * ALGORITHM/STEPS:
 * 1. Define a product interface that declares the operations all products must implement
 * 2. Create concrete product classes that implement the product interface
 * 3. Define a creator abstract class with:
 *    - A factory method (abstract) that returns a product
 *    - Optionally, operations that use products created by the factory method
 * 4. Create concrete creator classes that override the factory method to return specific products
 * 5. Client code uses creator classes to create products without knowing concrete types
 */

// Step 1: PRODUCT INTERFACE
// Declares the interface for objects the factory method creates
interface Notifications {
    void send(String message);
}

// Step 2: CONCRETE PRODUCTS
// Implement the product interface with specific implementations

/**
 * Concrete Product 1: Email Notification
 * Implements the Notifications interface for email-based notifications
 */
class Email implements Notifications {
    @Override
    public void send(String message) {
        System.out.println("Sending through Email: " + message);
    }
}

/**
 * Concrete Product 2: SMS Notification
 * Implements the Notifications interface for SMS-based notifications
 */
class SMSNotification implements Notifications {
    @Override
    public void send(String message) {
        System.out.println("Sending through SMS: " + message);
    }
}

// Step 3: CREATOR ABSTRACT CLASS
/**
 * Abstract Creator class that:
 * 1. Declares the factory method that returns a Notifications object
 * 2. May contain business logic that uses products created by factory method
 * 
 * Note: The creator may or may not implement the product interface itself
 * (This implementation follows the pattern where creator uses products but isn't a product)
 */
abstract class NotificationsCreator {
    
    /**
     * FACTORY METHOD (Abstract)
     * This is the core of the Factory Method Pattern
     * Subclasses will override this to create specific products
     * 
     * @return Notifications object (product)
     */
    public abstract Notifications createNotification();
    
    /**
     * BUSINESS LOGIC METHOD
     * Uses the factory method to get a product, then operates on it
     * This demonstrates how creator classes can work with products
     * without knowing their concrete types
     * 
     * @param message The message to be sent via notification
     */
    public void sendNotification(String message) {
        // Step 1: Call factory method to create product
        Notifications notification = createNotification();
        
        // Step 2: Use the product (polymorphic behavior)
        notification.send(message);
        
        // Note: The creator works with Notifications interface,
        // not knowing whether it's Email or SMSNotification
    }
}

// Step 4: CONCRETE CREATORS
// Override the factory method to return specific concrete products

/**
 * Concrete Creator 1: Email Creator
 * Overrides factory method to create Email products
 */
class EmailCreator extends NotificationsCreator {
    /**
     * Factory Method Implementation for Email
     * 
     * @return Email object (concrete product)
     */
    @Override
    public Notifications createNotification() {
        // Can add additional email-specific initialization here
        return new Email();
    }
}

/**
 * Concrete Creator 2: SMS Creator
 * Overrides factory method to create SMSNotification products
 */
class SMSCreator extends NotificationsCreator {
    /**
     * Factory Method Implementation for SMS
     * 
     * @return SMSNotification object (concrete product)
     */
    @Override
    public Notifications createNotification() {
        // Can add additional SMS-specific initialization here
        return new SMSNotification();
    }
}

// Step 5: CLIENT CODE
/**
 * Demo class showing Factory Method Pattern usage
 * Benefits:
 * 1. Client code depends on abstractions (NotificationsCreator, Notifications)
 * 2. Adding new notification types doesn't require modifying client code
 * 3. Single Responsibility Principle: Each creator handles one product type
 * 4. Open/Closed Principle: System is open for extension (new creators/products)
 *    but closed for modification
 */
public class FactoryMethodDemo {
    public static void main(String[] args) {
        System.out.println("=== FACTORY METHOD PATTERN DEMO ===\n");
        
        // Client works with creator abstractions, not concrete products
        NotificationsCreator emailCreator = new EmailCreator();
        System.out.println("Creating and sending email notification:");
        emailCreator.sendNotification("Hello! Your order has been confirmed.");
        
        System.out.println("\n------------------------------------\n");
        
        NotificationsCreator smsCreator = new SMSCreator();
        System.out.println("Creating and sending SMS notification:");
        smsCreator.sendNotification("Alert: Your package has been delivered.");
        
        System.out.println("\n=== PATTERN BENEFITS DEMONSTRATED ===");
        System.out.println("1. Client code doesn't know concrete product classes");
        System.out.println("2. Product creation logic is encapsulated in creators");
        System.out.println("3. Easy to add new notification types (PushNotification, etc.)");
    }
}