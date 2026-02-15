package Typesofcopies.Copy;

class Address{
    String city;
    public 
    Address(String city){
        this.city=city;
    }
  
}

class Person implements Cloneable{
    String name ;
    Address address ;
    Person(String name , Address address ){
        this.name = name ;
        this.address = address;

    }
    @Override
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}

public class ShallowCopy {
    public static void main(String arg[]) throws Exception{
        Address add = new Address("pune");
        Person p1 =  new Person("ABC " , add);
        System.out.println(p1.address.city);
        Person p2 = (Person) p1.clone();
        p1.address.city ="Mumbai";


          System.out.println(p2.address.city);
    }
    
}
