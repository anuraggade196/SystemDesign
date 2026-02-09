package simplefactory;

public class GoodDesign {

    interface Car {
        void drive();
    }

    static class Sedan implements Car {
        public void drive() {
            System.out.println("Driving a Sedan");
        }
    }

    static class SUV implements Car {
        public void drive() {
            System.out.println("Driving an SUV");
        }
    }

    // Simple Factory centralizes object creation
    static class CarFactory {
        public static Car createCar(String type) {
            if (type.equalsIgnoreCase("sedan")) return new Sedan();
            if (type.equalsIgnoreCase("suv")) return new SUV();
            return null;
        }
    }

    public static void main(String[] args) {
        Car c1 = CarFactory.createCar("sedan");
        c1.drive();

        Car c2 = CarFactory.createCar("suv");
        c2.drive();

        Car c3 = CarFactory.createCar("sedan");
        c3.drive();
    }
}
