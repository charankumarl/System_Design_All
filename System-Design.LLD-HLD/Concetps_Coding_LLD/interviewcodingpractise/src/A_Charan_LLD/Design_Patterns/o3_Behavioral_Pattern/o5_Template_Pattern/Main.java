package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o5_Template_Pattern;

public class Main {

    public static void main(String[] args) {

        Beverage coffee = new Coffee();
        coffee.prepareBeverage();

        Beverage tea = new Tea();
        tea.prepareBeverage();
    }
}
