package A_Charan_LLD.Design_Patterns.o1_Creational_Pattern.o4_Factory_Abstract_Factory.Abstract_Factory;

import A_Charan_LLD.Design_Patterns.o1_Creational_Pattern.o4_Factory_Abstract_Factory.Factory.Chicken_Pizza;
import A_Charan_LLD.Design_Patterns.o1_Creational_Pattern.o4_Factory_Abstract_Factory.Factory.Pizza;

public class Chicken_Pizza_Factory implements Pizza_Factory{

    @Override
    public Pizza createPizza(String type) {
        if(type.equals("chicken")){
            return new Chicken_Pizza();
        }
        else if(type.equals("chicken1")){
            return new Chicken_Pizza1();
        }
        else{
            throw new IllegalArgumentException("Unknown pizza type: " + type);
        }
    }
}
