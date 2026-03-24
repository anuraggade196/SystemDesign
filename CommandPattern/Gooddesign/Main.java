package CommandPattern.Gooddesign;

class Light{
    public void on(){
        System.out.println("Light turned on");
    }
    public void off(){
        System.out.println("Light turned off");
    }

}

class AC{
    public void on(){
        System.out.println("AC turned on");
    }
    public void off(){
        System.out.println("AC turned off");
    }
}

interface Command{
    public void execute();
    public void undo();
}

class LightOnCommand implements Command{
    private Light light ;
    public LightOnCommand(Light light){
        this.light=light;
    }
    public void execute(){
        light.on();
    }
    public void undo(){
        light.off();
    }

}
class LightOffCommand implements Command{
    private Light light ;
    public LightOffCommand(Light light){
        this.light = light ;
    }
    public void execute(){
        light.off();
    }
    public void undo(){
        light.on();
    }
}
class ACOnCommand implements Command{
    private AC ac ;
    public ACOnCommand(AC ac){
        this.ac = ac;
    }
    public void execute(){
        ac.on();
    }
    public void undo(){
        ac.off();
    }
}


class ACOffCommand implements Command{
    private AC ac ;
    public ACOffCommand(AC ac){
        this.ac = ac;
    }
    public void execute(){
        ac.off();
    }
    public void undo(){
        ac.on();
    }
}
class RemoteControl {
    private Command command ;
    private Command lastCommand ;
    public void setCommand (Command command){
        this.command= command;
    }

    public void pressButton(){
        if(command != null){
            command.execute(); 
            lastCommand =command;
        }
    }
    public void pressUndo(){
        if(lastCommand != null){
            System.out.println("Undoing last command");
            lastCommand.undo();

        }
    }
}
public class Main {
    public static void main(String [] args){
        Light livingRoomLight = new Light();
        AC bedroomAC = new AC();
  LightOnCommand lightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand lightOff = new LightOffCommand(livingRoomLight);
        ACOnCommand acOn = new ACOnCommand(bedroomAC);
        ACOffCommand acOff = new ACOffCommand(bedroomAC);
          RemoteControl remote = new RemoteControl();
           System.out.println("=== Testing Light ===");
          remote.setCommand(lightOn);
          remote.pressButton();
          remote.pressUndo();
          System.out.println("Testing AC");
            remote.setCommand(acOn);
        remote.pressButton();     // AC is on
        remote.pressUndo(); 
         System.out.println("\n=== Switching Commands ===");
        remote.setCommand(lightOff);
        remote.pressButton();     // Light is off
        remote.setCommand(acOff);
        remote.pressButton();     

    }
    
}
