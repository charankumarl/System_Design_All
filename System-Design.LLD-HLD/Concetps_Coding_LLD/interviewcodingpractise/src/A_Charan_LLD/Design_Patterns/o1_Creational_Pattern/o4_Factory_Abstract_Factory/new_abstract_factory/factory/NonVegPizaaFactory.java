package A_Charan_LLD.Design_Patterns.o1_Creational_Pattern.o4_Factory_Abstract_Factory.new_abstract_factory.factory;

import A_Charan_LLD.Design_Patterns.o1_Creational_Pattern.o4_Factory_Abstract_Factory.new_abstract_factory.pizza.*;

public class NonVegPizaaFactory implements Pizza_Factory{

    @Override
    public Pizza createPizza(String type) {

        if(type.equals("Veg Pizza")){
            return new NonVeg1();
        }
        else if(type.equals("Veg Pizza1")){
            return new NonVeg2();
        }
        else {
            return null;
        }
    }
}
