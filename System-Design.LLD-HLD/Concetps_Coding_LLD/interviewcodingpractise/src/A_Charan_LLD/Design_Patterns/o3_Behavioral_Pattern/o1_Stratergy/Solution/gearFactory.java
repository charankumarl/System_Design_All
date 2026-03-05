package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o1_Stratergy.Solution;

public class gearFactory {

    Gear_Strategy gear_strategy;

    public static Gear_Strategy getGear_Strategy(GearType gearType){

        if(gearType == GearType.AUTOMATIC){

            return new Automatic_Gear();

        }
        else if(gearType == GearType.MANUAL){

            return new Manual_Gear();
        }
        else{
            throw new IllegalArgumentException("GearType not found");
        }
    }
}
