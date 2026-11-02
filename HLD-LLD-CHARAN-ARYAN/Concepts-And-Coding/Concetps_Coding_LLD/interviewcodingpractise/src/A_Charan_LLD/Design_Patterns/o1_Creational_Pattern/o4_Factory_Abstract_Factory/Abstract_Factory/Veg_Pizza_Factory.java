package A_Charan_LLD.Design_Patterns.o1_Creational_Pattern.o4_Factory_Abstract_Factory.Abstract_Factory;

import A_Charan_LLD.Design_Patterns.o1_Creational_Pattern.o4_Factory_Abstract_Factory.Factory.Pizza;
import A_Charan_LLD.Design_Patterns.o1_Creational_Pattern.o4_Factory_Abstract_Factory.Factory.Veg_Pizza;

public class Veg_Pizza_Factory implements Pizza_Factory{

    @Override
    public Pizza createPizza(String type) {
        return new Veg_Pizza();
    }
}
