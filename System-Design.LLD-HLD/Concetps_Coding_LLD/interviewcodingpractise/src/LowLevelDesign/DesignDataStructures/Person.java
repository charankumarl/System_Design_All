package LowLevelDesign.DesignDataStructures;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Person {
    private int id;
    private String name;
    private String email;

    public Person(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // ✅ equals() method
    @Override
    public boolean equals(Object o) {

        if (this == o) return true;                  // same reference
        if (!(o instanceof Person)) return false; // check type
        Person person = (Person) o;

        return id == person.id &&
                Objects.equals(name, person.name) &&
                Objects.equals(email, person.email);
    }

    // ✅ hashCode() method
    @Override
    public int hashCode() {
        return Objects.hash(id, name, email);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static void main(String[] args) {

        Map<Person, String> map = new HashMap<>();

        Person emp1 = new Person(1, "Alice", "a");
        Person emp2 = new Person(2, "Bob", "a");
        Person emp3 = new Person(1, "Alice", "a"); // same data as emp1

        map.put(emp1, "HR");
        map.put(emp2, "Engineering");

        System.out.println(map.get(emp1)); // HR
        System.out.println(map.get(emp3)); // HR (if equals/hashCode are correct)

        /*
        What Happens If You Don’t Override equals() and hashCode()?
The default implementation (from Object) uses memory address-based equality.

Even if two Employee objects have the same values, they will be treated as different keys unless you override the methods.

map.get(emp3) would return null in the above case without overrides.
         */
    }
}

