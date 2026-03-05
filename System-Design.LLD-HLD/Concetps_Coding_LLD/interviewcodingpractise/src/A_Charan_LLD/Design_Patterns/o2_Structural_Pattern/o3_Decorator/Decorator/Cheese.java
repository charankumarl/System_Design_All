package A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o3_Decorator.Decorator;

import A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o3_Decorator.Base.Pizza;

public class Cheese extends Pizza_Decorator{

    public Cheese(Pizza pizza) {
        super(pizza);
    }

    public String description() {
        return pizza.description() + " Cheese";
    }

    public int cost() {
        return pizza.cost() + 10;
    }
}
