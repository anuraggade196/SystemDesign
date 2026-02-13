package AbstractFactory.Gooddesign;

// Define the Button interface that declares methods for all button types
interface Button {
    void paint();     // Method to render the button
    void onClick();   // Method to handle button click events
}

// Define the Checkbox interface that declares methods for all checkbox types
interface Checkbox {
    void paint();     // Method to render the checkbox
    void onSelect();  // Method to handle checkbox selection events
}

// Concrete implementation of Button for Windows operating system
class WindowsButton implements Button {

    @Override
    public void paint() {
        // Windows-specific button rendering logic
        System.out.println("Windows Button");
    }

    @Override
    public void onClick() {
        // Windows-specific button click behavior
        System.out.println("Windows button clicked");
    }
}

// Concrete implementation of Checkbox for Windows operating system
class WindowsCheckbox implements Checkbox {

    @Override
    public void paint() {
        // Windows-specific checkbox rendering logic
        System.out.println("Windows Checkbox");
    }

    @Override
    public void onSelect() {
        // Windows-specific checkbox selection behavior
        System.out.println("Windows checkbox selected");
    }
}

// Concrete implementation of Button for Mac operating system
class MacButton implements Button {

    @Override
    public void paint() {
        // Mac-specific button rendering logic
        System.out.println("Mac Button");
    }

    @Override
    public void onClick() {
        // Mac-specific button click behavior
        System.out.println("Mac button clicked");
    }
}

// Concrete implementation of Checkbox for Mac operating system
class MacCheckbox implements Checkbox {

    @Override
    public void paint() {
        // Mac-specific checkbox rendering logic
        System.out.println("Mac Checkbox");
    }

    @Override
    public void onSelect() {
        // Mac-specific checkbox selection behavior
        System.out.println("Mac checkbox selected");
    }
}

// Abstract Factory interface that declares factory methods for creating
// families of related products (Button and Checkbox)
interface AbstractFactory {
    Button createButton();      // Factory method to create a Button
    Checkbox createCheckbox();  // Factory method to create a Checkbox
}

// Concrete factory implementation for creating Windows family products
class WindowsFactory implements AbstractFactory {

    @Override
    public Button createButton() {
        // Returns a Windows-specific Button instance
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        // Returns a Windows-specific Checkbox instance
        return new WindowsCheckbox();
    }
}

// Concrete factory implementation for creating Mac family products
class MacFactory implements AbstractFactory {

    @Override
    public Button createButton() {
        // Returns a Mac-specific Button instance
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        // Returns a Mac-specific Checkbox instance
        return new MacCheckbox();
    }
}

// Application class that uses the abstract factory to create UI components
// This class is decoupled from specific platform implementations
class Application {

    // References to abstract product interfaces
    private final Button button;      // Will hold platform-specific button
    private final Checkbox checkbox;  // Will hold platform-specific checkbox

    // Constructor receives an AbstractFactory to create platform-specific components
    public Application(AbstractFactory factory) {
        // Create button using the provided factory
        this.button = factory.createButton();
        // Create checkbox using the provided factory
        this.checkbox = factory.createCheckbox();
    }

    // Method to render the complete UI
    public void renderUI() {
        // Render the button
        button.paint();
        // Render the checkbox
        checkbox.paint();
    }
}

// Main class to demonstrate the Abstract Factory pattern
public class Design {

    public static void main(String[] args) {

        // Get the operating system name from system properties
        String os = System.getProperty("os.name");
        
        // Declare a reference to an AbstractFactory
        AbstractFactory factory;

        // Determine which factory to create based on the operating system
        if (os.contains("Windows")) {
            // If running on Windows, create WindowsFactory
            factory = new WindowsFactory();
        } else {
            // If not Windows (assume Mac), create MacFactory
            factory = new MacFactory();
        }

        // Create the application with the appropriate factory
        Application app = new Application(factory);
        
        // Render the UI, which will use platform-specific components
        app.renderUI();
    }
}