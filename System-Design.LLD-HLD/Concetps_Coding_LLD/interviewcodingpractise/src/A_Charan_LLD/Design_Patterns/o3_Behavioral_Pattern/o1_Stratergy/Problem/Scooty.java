package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o1_Stratergy.Problem;

public class Scooty extends Bike{

    @Override
    void gear(){
        System.out.println("Automatic Gear System");  // Both Scooty and Electric have same gear system. Duplication of code
    }
}
