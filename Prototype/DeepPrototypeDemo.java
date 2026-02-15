// Prototype Interface
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

    // Deep Copy
    public Prototype clone() {
        try {
            Person cloned = (Person) super.clone();
            cloned.address = new Address(this.address.city); // new object
            return cloned;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    void display() {
        System.out.println(name + " lives in " + address.city);
    }
}

// Client
public class DeepPrototypeDemo {
    public static void main(String[] args) {

        Person p1 = new Person("A", new Address("Pune"));

        Person p2 = (Person) p1.clone();

        p2.address.city = "Mumbai";

        p1.display();
        p2.display();
    }
}
