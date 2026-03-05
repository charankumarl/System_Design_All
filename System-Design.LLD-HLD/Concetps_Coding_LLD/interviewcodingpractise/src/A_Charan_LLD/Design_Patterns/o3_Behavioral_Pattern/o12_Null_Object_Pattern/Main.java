package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o12_Null_Object_Pattern;

public class Main {

    public static void main(String[] args) {

        Vehicles car = Vehicles_Factory.getVehicle(Objects.CAR);

        System.out.println(car.getCapacity());
        System.out.println(car.getSpeed());

        //----------------------------------------------------------------------------//

        Vehicles bike = Vehicles_Factory.getVehicle(Objects.BIKE);  // Object bike is NULL.

        // Without Null Object.
        if(bike != null){
            System.out.println(bike.getCapacity());
            System.out.println(bike.getSpeed());
        }

        // We can avoid this null check by using Null Object Pattern.

        System.out.println(bike.getCapacity());
        System.out.println(bike.getSpeed());
    }
}
