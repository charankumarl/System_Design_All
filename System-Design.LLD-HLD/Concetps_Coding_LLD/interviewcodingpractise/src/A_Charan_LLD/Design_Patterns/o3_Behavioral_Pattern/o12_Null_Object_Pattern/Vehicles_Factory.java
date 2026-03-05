package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o12_Null_Object_Pattern;

import LowLevelDesign.HandleNullObject.NullVehicle;

public class Vehicles_Factory {

    public static Vehicles getVehicle(Objects vehicleType){

        if(vehicleType == Objects.CAR){
            return new Car();
        }

        return new Null();
    }
}
