package A_Charan_LLD.Design_Patterns.o1_Creational_Pattern.o4_Factory_Abstract_Factory.Abstract_Factory;

import A_Charan_LLD.Design_Patterns.o1_Creational_Pattern.o4_Factory_Abstract_Factory.Factory.Pizza;

public class Main {

    public static void main(String[] args) {

        Pizza_Factory veg = Pizza_Factory_Producer.getFactory("veg");

        Pizza pizza = veg.createPizza("veg");

        pizza.prepare();
        pizza.bake();
        pizza.box();

        Pizza_Factory c1 = Pizza_Factory_Producer.getFactory("chicken");

        Pizza pizza1 = c1.createPizza("chicken1");

        pizza1.prepare();
        pizza1.bake();
        pizza1.box();
    }
}
