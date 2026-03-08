package Flyweight.Baddesign;

class Tree{
    private String type ;
    private String color ;
    private String texture ;
    private double latitude ;
    private double longitude;
public Tree(String type , String color , String texture , double latitude , double longitude){
    this.type = type;
    this.color = color;
    this.texture = texture ;
    this.latitude = latitude;
    this.longitude = longitude;
    

}
  public void display() {
            System.out.println(type + " tree at (" + latitude + ", " + longitude + ") color: " + color);
        }
   
}
public  class Main {
    public static void main(String [] args){
           Tree tree1 = new Tree("Oak", "Green", "Rough", 18.5204, 73.8567);
        Tree tree2 = new Tree("Oak", "Green", "Rough", 18.5205, 73.8568);
        Tree tree3 = new Tree("Oak", "Green", "Rough", 18.5206, 73.8569);

        tree1.display();
        tree2.display();
        tree3.display();
    }

     
}