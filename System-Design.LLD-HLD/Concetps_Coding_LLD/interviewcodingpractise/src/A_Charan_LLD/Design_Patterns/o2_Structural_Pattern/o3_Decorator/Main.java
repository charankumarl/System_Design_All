package A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o3_Decorator;

import A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o3_Decorator.Base.Pizza;
import A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o3_Decorator.Base.Plain_Veg_Pizza;
import A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o3_Decorator.Base.Plain_Chicken_Pizza;
import A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o3_Decorator.Decorator.Cheese;
import A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o3_Decorator.Decorator.Mushroom;

public class Main {

    public static void main(String[] args) {

        Pizza pizza = new Plain_Veg_Pizza();
        System.out.println(pizza.description());
        System.out.println("Cost: " + pizza.cost());

        pizza = new Cheese(pizza);
        System.out.println(pizza.description());
        System.out.println("Cost: " + pizza.cost());

        Pizza chicken_pizza = new Plain_Chicken_Pizza();
        System.out.println(chicken_pizza.description());
        System.out.println("Cost: " + chicken_pizza.cost());

        chicken_pizza = new Mushroom(chicken_pizza);
        System.out.println(chicken_pizza.description());
        System.out.println("Cost: " + chicken_pizza.cost());

        //Pizza p= new Cheese(new Mushroom(new Plain_Veg_Pizza()));
    }
}
