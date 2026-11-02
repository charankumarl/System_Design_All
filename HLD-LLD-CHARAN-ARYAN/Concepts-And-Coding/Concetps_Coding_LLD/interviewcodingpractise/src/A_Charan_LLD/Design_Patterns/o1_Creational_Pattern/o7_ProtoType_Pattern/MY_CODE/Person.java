package A_Charan_LLD.Design_Patterns.o1_Creational_Pattern.o7_ProtoType_Pattern.MY_CODE;

public class Person implements Cloneable{

    String name;
    Address address;

    Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    // Shallow copy
    protected Object shallowCopy() throws CloneNotSupportedException {
        return super.clone();
    }

    // Deep copy
    protected Object deepCopy() throws CloneNotSupportedException {
        Person cloned = (Person) super.clone();
        cloned.address = (Address) address.clone(); // clone referenced object  or   new Address(pass the address details);
        // this points to different address and changes won't affect the original object
        return cloned;

        // instead of referencing to same Address object, we create a new Address object

        /*
            This creates a new Address object that is a copy of the original address.

        (Address) casts the returned Object from clone() back to the Address type.

        Then, the cloned object's address field is set to this new cloned Address, instead of sharing the same Address object
        as the original.
         */
    }

    @Override
    public String toString() {
        return name + " from " + address;
    }
}
