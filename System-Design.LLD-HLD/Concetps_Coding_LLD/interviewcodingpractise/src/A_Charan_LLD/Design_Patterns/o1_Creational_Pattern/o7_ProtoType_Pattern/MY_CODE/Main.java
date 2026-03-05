package A_Charan_LLD.Design_Patterns.o1_Creational_Pattern.o7_ProtoType_Pattern.MY_CODE;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {

        Address addr = new Address("New York");
        Person p1 = new Person("Alice", addr);

        // Shallow copy
        Person p2 = (Person) p1.shallowCopy();

        // Deep copy
        Person p3 = (Person) p1.deepCopy();

        System.out.println("Before change:");
        System.out.println("p1: " + p1);
        System.out.println("p2 (shallow copy): " + p2);
        System.out.println("p3 (deep copy): " + p3);

        // Change address city in p1
        p1.address.city = "Los Angeles";

        System.out.println("\nAfter change in p1's address:");
        System.out.println("p1: " + p1);
        System.out.println("p2 (shallow copy): " + p2); // address changed too!
        System.out.println("p3 (deep copy): " + p3);    // address remains same
    }

    /*

    Before change:
        p1: Alice from New York
        p2 (shallow copy): Alice from New York
        p3 (deep copy): Alice from New York

    After change in p1's address:
        p1: Alice from Los Angeles
        p2 (shallow copy): Alice from Los Angeles
        p3 (deep copy): Alice from New York
     */
}
