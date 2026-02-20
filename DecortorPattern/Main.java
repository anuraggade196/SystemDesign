
interface Beverage {
    String getDescription();
    int cost();
}

// --- Concrete Component ---
class BasicCoffee implements Beverage {
    public String getDescription() { 
        return "Coffee"; 
    }
    public int cost() { 
        return 50; 
    }
}

// --- Decorator Base Class ---
abstract class AddOnDecorator implements Beverage {
    protected Beverage beverage;
    
    AddOnDecorator(Beverage beverage) {
        this.beverage = beverage;
    }
}

// --- Concrete Decorators ---
class Milk extends AddOnDecorator {
    Milk(Beverage beverage) {
        super(beverage);
    }

    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }

    public int cost() {
        return beverage.cost() + 10;
    }
}

class Chocolate extends AddOnDecorator {
    Chocolate(Beverage beverage) {
        super(beverage);
    }

    public String getDescription() {
        return beverage.getDescription() + ", Chocolate";
    }

    public int cost() {
        return beverage.cost() + 20;
    }
}

class Cream extends AddOnDecorator {
    Cream(Beverage beverage) {
        super(beverage);
    }

    public String getDescription() {
        return beverage.getDescription() + ", Cream";
    }

    public int cost() {
        return beverage.cost() + 30;
    }
}

// --- MAIN CLASS ---
public class Main {
    public static void main(String[] args) {

        // Base Item
        Beverage order = new BasicCoffee(); // 50

        // Adding Decorators Dynamically
        order = new Milk(order);            // +10
        order = new Chocolate(order);       // +20
        order = new Cream(order);           // +30

        System.out.println("Order: " + order.getDescription());
        System.out.println("Total Cost: " + order.cost());
    }
}