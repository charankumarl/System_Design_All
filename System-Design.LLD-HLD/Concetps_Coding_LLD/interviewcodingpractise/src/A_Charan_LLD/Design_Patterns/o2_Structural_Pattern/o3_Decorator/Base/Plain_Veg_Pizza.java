package A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o3_Decorator.Base;

public class Plain_Veg_Pizza implements Pizza{

    @Override
    public String description() {
        return "Plain Veg Pizza";
    }

    @Override
    public int cost() {
        return 100;
    }
}
