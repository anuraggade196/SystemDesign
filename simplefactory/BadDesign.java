package simplefactory;

public class BadDesign {

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

    public static void main(String[] args) {

        // BAD: Object creation scattered everywhere
        Car c1 = new Sedan();
        c1.drive();

        Car c2 = new SUV();
        c2.drive();

        // BAD: Repeated if-else logic
        String type = "sedan";
        Car c3;
        if (type.equalsIgnoreCase("sedan")) {
            c3 = new Sedan();
        } else {
            c3 = new SUV();
        }
        c3.drive();
    }
}
