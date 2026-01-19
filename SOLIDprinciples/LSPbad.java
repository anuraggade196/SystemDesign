package SOLIDprinciples;
class vehicle {
    void startengine(){
        System.out.println("Engine is started");
    }
}

class car extends  vehicle{
    @Override
    void startengine(){
        System.out.println("Car engine is started");
    }
}

class bicycle extends vehicle{
    @Override
    void startengine(){
       throw new UnsupportedOperationException("Bicycles don't have engines");
    }
}
public class LSPbad {
    public static void main(String args[]){
         vehicle car = new car();
    vehicle bicycle = new bicycle();
    // Using polymorphism
    System.out.println("Car:");
    car.startengine();  // Output: Car engine started.
    System.out.println("nBicycle:");
    try {
      bicycle.startengine();  // Throws UnsupportedOperationException
    } catch (UnsupportedOperationException e) {
      System.out.println("Error: " + e.getMessage());
    }
    }
    
}
