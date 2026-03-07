package BridgePattern.BadDesign;

class PetroSUV{
      void drive() {
            System.out.println("SUV with Petrol Engine");
        }
}

class DiselSUV{
    void drive(){
        System.out.println("SUV with Petrol Engine");
    }
}
 class PetrolSportsCar {
        void drive() {
            System.out.println("SportsCar with Petrol Engine");
        }
    }

class DieselSportsCar {
        void drive() {
            System.out.println("SportsCar with Diesel Engine");
        }
    }

public class Main {

    public static void main(String [] args){
         PetroSUV petrolSUV = new PetroSUV();
        petrolSUV.drive();

        DieselSportsCar dieselSportsCar = new DieselSportsCar();
        dieselSportsCar.drive();
    }
    
}
