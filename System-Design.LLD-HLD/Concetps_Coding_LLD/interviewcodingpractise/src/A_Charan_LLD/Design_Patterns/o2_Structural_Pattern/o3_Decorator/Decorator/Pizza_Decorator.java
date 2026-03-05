package A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o3_Decorator.Decorator;

import A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o3_Decorator.Base.Pizza;

public abstract class Pizza_Decorator implements Pizza {

    Pizza pizza;

    public Pizza_Decorator(Pizza pizza){
        this.pizza = pizza;
    }

    @Override
    public String description() {   // not required also this 2 things.
        return pizza.description();
    }

    @Override
    public int cost() {    // not required also
        return pizza.cost();
    }
}
