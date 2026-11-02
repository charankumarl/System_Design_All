package A_Charan_LLD.Design_Patterns.o1_Creational_Pattern.o7_ProtoType_Pattern;

public class Car_DeepCopy implements ProtoType{

    private String brand;
    private String model;
    private int price;

    public Car_DeepCopy(String brand, String model, int price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public Car_DeepCopy clone() throws CloneNotSupportedException{
        return (Car_DeepCopy) super.clone();  // we can avoid creating new object and setting all fields manually.
    }

    /*
        How super.clone() Works
        Creates a new object:
        super.clone() creates a shallow copy of the object.
        It copies primitive fields directly.
        It copies references for objects, meaning changes to mutable fields (like lists, maps, or other objects)
        in one instance will reflect in the other.
        Does NOT call constructors:
        Unlike new Car(...), clone() does not invoke constructors.
     */

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}
