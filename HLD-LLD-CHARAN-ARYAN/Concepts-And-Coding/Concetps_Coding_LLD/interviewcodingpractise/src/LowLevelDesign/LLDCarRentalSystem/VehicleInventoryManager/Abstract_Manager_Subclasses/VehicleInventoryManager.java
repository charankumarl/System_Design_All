package LowLevelDesign.LLDCarRentalSystem.VehicleInventoryManager.Abstract_Manager_Subclasses;

import LowLevelDesign.LLDCarRentalSystem.Product.Vehicle;
import java.util.*;

public abstract class VehicleInventoryManager<T extends Vehicle> {

    protected List<T> vehicles = new ArrayList<>();

    public void addVehicle(T vehicle) {
        vehicles.add(vehicle);
    }

    public void removeVehicle(String vehicleId) {

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleID() == Integer.parseInt(vehicleId)) {
                vehicles.remove(vehicle);
                return;
            }
        }
    }

    public List<T> listVehicles() {
        return new ArrayList<>(vehicles);
    }

    /*
      1. What is <T extends Vehicle>, what happens if we dont use this.

         -> Your inventory manager only handles the base Vehicle type.

            Internally, you store a list of Vehicle objects — which can be bikes, cars, autos, etc. because they all inherit from Vehicle.

            When you get vehicles from the list, they come as Vehicle references (not specific subclasses).

            If you want to do something specific to Bike or Car, you would need to type-check and cast.

            for (Vehicle v : inventoryManager.listVehicles()) {
                if (v instanceof Bike) {
                    Bike bike = (Bike) v;
                    // do bike-specific logic
                }

        2. <T extends Vehicle> means?

            T can be any type of Vehicle, which are SUBCLASS of Vehicle.

            -> If we just mention T, then it can be anything, Integer, String etc,  So we mention T is type of Vehicle.

            public void printVehicleId(T vehicle) {
                System.out.println(vehicle.getVehicleId());  // <-- compiler error if T is not guaranteed to have getVehicleId()



        -> 2 useful. We are telling that this class will handle only Vehicle or its subclasses,
         which allows us to use methods defined in the Vehicle class directly on T without casting.
     */
}
