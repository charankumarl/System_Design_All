package A_Charan_LLD.Design_Patterns.o1_Creational_Pattern.o4_Factory_Abstract_Factory.Factory;

public class Veg_Pizza implements Pizza{

    @Override
    public void prepare() {
        System.out.println("Preparing Veg Pizza");
    }

    @Override
    public void bake() {
        System.out.println("Baking Veg Pizza");
    }

    @Override
    public void box() {
        System.out.println("Packing Veg Pizza");
    }
}
