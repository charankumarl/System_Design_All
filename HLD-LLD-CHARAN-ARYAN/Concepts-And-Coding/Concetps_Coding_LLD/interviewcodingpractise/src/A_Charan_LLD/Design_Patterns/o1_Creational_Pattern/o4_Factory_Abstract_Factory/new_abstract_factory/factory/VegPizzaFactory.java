package A_Charan_LLD.Design_Patterns.o1_Creational_Pattern.o4_Factory_Abstract_Factory.new_abstract_factory.factory;

import A_Charan_LLD.Design_Patterns.o1_Creational_Pattern.o4_Factory_Abstract_Factory.new_abstract_factory.pizza.Pizza;
import A_Charan_LLD.Design_Patterns.o1_Creational_Pattern.o4_Factory_Abstract_Factory.new_abstract_factory.pizza.Veg2;
import A_Charan_LLD.Design_Patterns.o1_Creational_Pattern.o4_Factory_Abstract_Factory.new_abstract_factory.pizza.veg1;

public class VegPizzaFactory implements Pizza_Factory{


    @Override
    public Pizza createPizza(String type) {

        if(type.equals("Veg Pizza")){
            return new veg1();
        }
        else if(type.equals("Veg Pizza1")){
            return new Veg2();
        }
        else {
            return null;
        }
    }
}
