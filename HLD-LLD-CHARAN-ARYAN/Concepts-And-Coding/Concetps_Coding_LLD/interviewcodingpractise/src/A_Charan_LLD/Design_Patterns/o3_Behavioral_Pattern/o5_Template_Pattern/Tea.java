package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o5_Template_Pattern;

public class Tea extends Beverage{

    @Override
    protected void brew() {
        System.out.println("Steeping tea...");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding lemon...");
    }
}
