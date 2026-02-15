package Typesofcopies.Copy;

class Address implements Cloneable {
    String city;

    Address(String city) {
        this.city = city;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Person implements Cloneable {

    String name;
    Address address;

    Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {

        Person cloned = (Person) super.clone();   // Step 3

        // Step 4: Deep copy of reference object
        cloned.address = (Address) address.clone();

        return cloned;
    }
}

public class DeepCopy {
    public static void main(String[] args) throws Exception {

        Address add = new Address("pune");
        Person p1 = new Person("ABC", add);

        Person p2 = (Person) p1.clone();

        p1.address.city = "Mumbai";

        System.out.println(p1.address.city); // Mumbai
        System.out.println(p2.address.city); // pune  ✅ independent
    }
}
