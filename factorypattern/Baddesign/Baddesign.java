package FactoryPattern.Baddesign;

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

class Logisticsservice {

    public void service(String mode) {

        if ("Air".equalsIgnoreCase(mode)) {
            Logistics instance = new Air();
            instance.send();
        }
        else if ("road".equalsIgnoreCase(mode)) {
            Logistics instance = new Road();
            instance.send();
        }
    }
}

public class Baddesign {
    public static void main(String[] args) {
        Logisticsservice logisticsservice1 = new Logisticsservice();
        logisticsservice1.service("road");
    }
}
