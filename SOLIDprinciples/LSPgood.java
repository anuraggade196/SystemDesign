package SOLIDprinciples;

// Parent Interface: common behavior for all vehicles
interface Vehicle {
    void move();
}

// Sub-interface: ONLY for vehicles that have engines
interface EngineVehicle extends Vehicle {
    void startEngine();
}

// Car HAS an engine → implements EngineVehicle
class Car implements EngineVehicle {
    @Override
    public void move() {
        System.out.println("Car is moving");
    }

    @Override
    public void startEngine() {
        System.out.println("Car engine is started");
    }
}

// Bicycle DOES NOT have an engine → implements only Vehicle
class Bicycle implements Vehicle {
    @Override
    public void move() {
        System.out.println("Bicycle is moving");
    }
}

public class LSPgood {
    public static void main(String[] args) {

        // Polymorphism works correctly
        EngineVehicle car = new Car();
        Vehicle bicycle = new Bicycle();

        System.out.println("Car:");
        car.startEngine();
        car.move();

        System.out.println("\nBicycle:");
        bicycle.move();    // No exception → valid substitution
    }
}
