package BridgePattern.GoodDesign;

interface Engine{
    void start();
}

class PetrolEngine implements Engine{
    @Override
    public void start(){
        System.out.println("Starting Petrol Engine");
    }
}

class DieselEngine implements Engine{
      public void start(){
        System.out.println("Starting Disel Engine");
    }
}
abstract class Car{
    protected Engine engine ;
    Car(Engine engine){
        this.engine = engine;
    }
    abstract void drive();
}

class SUV extends Car{
    SUV(Engine engine){
        super(engine);
    }
     void drive() {
            engine.start();
            System.out.println("Driving SUV");
        }
}
class SportsCar extends Car {

        SportsCar(Engine engine) {
            super(engine);
        }

        void drive() {
            engine.start();
            System.out.println("Driving Sports Car");
        }
    }

public class Main {

    public static void main(String [] args){
        Engine petrolEngine = new PetrolEngine();
        Car suv = new SUV(petrolEngine);
        suv.drive();

        System.out.println();

        Engine dieselEngine = new DieselEngine();
        Car sportsCar = new SportsCar(dieselEngine);
        sportsCar.drive();
    }
    
}
