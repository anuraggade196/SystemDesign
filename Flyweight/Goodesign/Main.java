package Flyweight.Goodesign;

import java.util.HashMap;

interface Tree{

    void display(double latitude , double longitude);


}

class TreeType implements Tree{
    private String name ;
    private String color ;
    private String texture;
    public TreeType(String name , String color , String texture){
        this.name = name;
        this.color = color;
        this.texture = texture;
    }
      public void display(double latitude, double longitude) {
            System.out.println(name + " tree at (" + latitude + ", " + longitude + ") color: " + color + " " + texture);
        }
}

class TreeFactory{
    private static HashMap<String , TreeType > map= new HashMap();
      public static TreeType getTreeType(String name, String color, String texture) {

            String key = name + color + texture;

            if (!map.containsKey(key)) {
                map.put(key, new TreeType(name, color, texture));
            }

            return map.get(key);
        }
}
public class Main {
       public static void main(String[] args) {

        TreeType oakTree1 = TreeFactory.getTreeType("Oak", "Green", "Rough");
        oakTree1.display(18.5204, 73.8567);

        TreeType oakTree2 = TreeFactory.getTreeType("Oak", "Green", "Rough");
        oakTree2.display(18.5205, 73.8568);

        TreeType pineTree = TreeFactory.getTreeType("Pine", "Dark Green", "Smooth");
        pineTree.display(18.5210, 73.8575);

        System.out.println(oakTree1 == oakTree2);
    }
    
}
