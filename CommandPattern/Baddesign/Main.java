package CommandPattern.Baddesign;

class Light{
    public void on(){
        System.out.println("Light on");
    }
    public void off(){
        System.out.println("Light off");
    }
}
class AC {
    public void on(){
        System.out.println("AC on");
    }
    public void off(){
        System.out.println("AC off");
    }
}
class RemoteControl{
    private Light light ;
    private AC ac ;
    public RemoteControl(Light light , AC ac){
        this.light = light;
        this.ac =ac ;
    }
    public void pressLighton(){
        light.on();
    }
    public void pressLightoff(){
        light.off();
    }
    public void pressACon(){
        ac.on();
    }
    public void pressACoff(){
        ac.off();
    }
}

public class Main {
    public static void main(String [] args){
        Light light = new Light();

        AC ac = new AC();
        RemoteControl remote = new RemoteControl(light, ac);
        remote.pressLighton();
        remote.pressLightoff();
        remote.pressACon();
        remote.pressACoff();

    }
    
}
