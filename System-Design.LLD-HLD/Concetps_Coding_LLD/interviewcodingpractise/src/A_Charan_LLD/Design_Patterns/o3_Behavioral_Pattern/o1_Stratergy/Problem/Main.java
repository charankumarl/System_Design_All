package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o1_Stratergy.Problem;

public class Main {

    public static void main(String[] args) {

        Sports_Bike sports_bike = new Sports_Bike();
        sports_bike.gear();

        Scooty scooty = new Scooty();  // Both Scooty and Electric have same gear system. Duplication of code.
        scooty.gear();

        Electric electric = new Electric();
        electric.gear();
    }
}
