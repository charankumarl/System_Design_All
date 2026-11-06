package A_Charan_LLD.Design_Patterns.o1_Creational_Pattern.o7_ProtoType_Pattern.MY_CODE;

public class Person implements Cloneable{

    /**
     *  Cloneable is a marker interface — empty, zero methods.
     *
     * public interface Cloneable {
     * }
     *
     * It just flags "this object is allowed to be cloned." Object.clone() checks at runtime if the class implements Cloneable — if not, throws CloneNotSupportedException.
     * The actual clone() method comes from Object, not from this interface.
     */

    String name;
    Address address;

    Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    // Shallow copy
    protected Object shallowCopy() throws CloneNotSupportedException {
        return super.clone();

        /**
         * - Primitives (int, boolean, double, char, etc.) → copied by value. New independent copy, no sharing.
         * - Objects / Arrays / Lists / Maps / Strings-of-objects-etc (any reference type) → the reference (pointer) is copied, not the object itself.
         * Both original and clone point to the same object in memory.
         */
    }

    // Deep copy
    protected Object deepCopy() throws CloneNotSupportedException {

        Person cloned = (Person) super.clone();   // here new person object is created, but inside objects are same reference.

        cloned.address = (Address) address.clone(); // here since inside object is same, we cloned inside object also, so new object with reference is created.

        return cloned;

        /**
         * Shallow copy:
         *  p1 ---> address --\
         *                     --> same Address object ("New York")
         *  p2 ---> address --/
         *
         * Deep copy:
         *  p1 ---> address ---> Address object A ("New York")
         *  p3 ---> address ---> Address object B (separate copy, "New York")
         *
         *  Explnation:
         *
         * Line 20: Person cloned = (Person) super.clone();
         * Copies name and address fields as-is. So right now: cloned.address == address (same object, same reference, pointing to original p1's Address).
         *
         * Line 21: cloned.address = (Address) address.clone();
         * - address.clone() → calls Address's clone, makes a brand new Address object (separate copy in memory), same city value.
         * - cloned.address = ... → overwrites cloned's address field, replacing the shared reference from line 20 with this new independent Address object.
         *
         * Before line 21: cloned.address → same Address as p1.address (shared).
         * After line 21: cloned.address → its own new Address (not shared anymore).
         */

    }

    @Override
    public String toString() {
        return name + " from " + address;
    }
}
