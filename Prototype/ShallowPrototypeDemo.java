
package Prototype;
interface Prototype {
    Prototype clone();
}

// Address class
class Address {
    String city;

    Address(String city) {
        this.city = city;
    }
}

// Concrete Prototype
class Person implements Prototype, Cloneable {
    String name;
    Address address;

    Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    // Shallow Copy
    public Prototype clone() {
        try {
            return (Person) super.clone();  // shallow copy
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    void display() {
        System.out.println(name + " lives in " + address.city);
    }
}

// Client
public class ShallowPrototypeDemo {
    public static void main(String[] args) {

        Person p1 = new Person("A", new Address("Pune"));
          p1.display();

        Person p2 = (Person) p1.clone();

        p2.address.city = "Mumbai";

        p1.display();
        p2.display();
    }
}
