package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o1_Stratergy.Solution;

public class Automatic_Gear implements Gear_Strategy{

    @Override
    public void gear() {
        System.out.println("Automatic Gear System");
    }
}
