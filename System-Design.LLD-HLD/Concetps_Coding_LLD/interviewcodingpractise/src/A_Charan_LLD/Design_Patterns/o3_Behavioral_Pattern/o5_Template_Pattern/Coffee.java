package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o5_Template_Pattern;

public class Coffee extends Beverage{

    @Override
    protected void brew() {
        System.out.println("Brewing coffee...");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding sugar and milk...");
    }
}
