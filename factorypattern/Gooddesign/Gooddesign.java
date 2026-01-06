package FactoryPattern.Gooddesign;

interface Logistics {
    void send();
}

class Road implements Logistics {
    @Override
    public void send() {
        System.out.println("sending through roads");
    }
}

class Air implements Logistics {
    @Override
    public void send() {
        System.out.println("sending though airs");
    }
}

class factorpattern {

    public static Logistics getlogistics(String mode) {

        if (mode == "Road") {
            return new Road();
        } else {
            return new Air();  
        }
    }
}

class Logisticsservice {

    public void service(String mode) {
        Logistics logistics = factorpattern.getlogistics(mode);
        logistics.send();
    }
}

public class Gooddesign {
    public static void main(String[] args) {

        Logisticsservice logisticsservice1 = new Logisticsservice();

        logisticsservice1.service("Road");
        logisticsservice1.service("Air");
        logisticsservice1.service("train");

    }
}
