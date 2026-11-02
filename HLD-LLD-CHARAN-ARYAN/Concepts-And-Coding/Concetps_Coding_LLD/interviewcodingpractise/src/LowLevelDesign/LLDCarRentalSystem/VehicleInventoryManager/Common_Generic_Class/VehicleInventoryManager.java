package LowLevelDesign.LLDCarRentalSystem.VehicleInventoryManager.Common_Generic_Class;

import LowLevelDesign.LLDCarRentalSystem.Product.Vehicle;

import java.util.List;

public interface VehicleInventoryManager {

    void addVehicle(Vehicle vehicle);
    void removeVehicle(String vehicleId);
    List<Vehicle> listVehicles();
}
