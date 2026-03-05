package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o12_Null_Object_Pattern;

public class Null implements Vehicles{

    @Override
    public int getCapacity() {
        return 0;
    }

    @Override
    public int getSpeed() {
        return 0;
    }
}
