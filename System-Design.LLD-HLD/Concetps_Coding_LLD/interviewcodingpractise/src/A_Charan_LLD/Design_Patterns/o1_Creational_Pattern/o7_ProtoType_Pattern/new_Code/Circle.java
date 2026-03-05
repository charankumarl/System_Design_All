package A_Charan_LLD.Design_Patterns.o1_Creational_Pattern.o7_ProtoType_Pattern.new_Code;

public class Circle implements Shape{

    private int rad;
    Circle(int rad){
        this.rad = rad;
    }

    @Override
    public void draw() {
        System.out.println("draw circle" + this.rad);
    }

    @Override
    public Shape clone() {
        return new Circle(this.rad);    /// deep copy, no reference is passed.
    }


    /**
     *
     * Address address;
     *
     * @Override
     *     public Shape clone() {
     *         return new Circle(this.rad);    /// shallow copy, no reference is passed.
     *
     *         return new Circle(this.rad, this.address); // Shallow copy -> We are pointing to same address object,
     *
     *         // if we cahnge address in cloned object, it will reflect in original object also.
     *     }
     */
}
