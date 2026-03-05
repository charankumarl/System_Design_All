package LowLevelDesign.LLDCarRentalSystem.VehicleInventoryManager.Common_Generic_Class;

import LowLevelDesign.LLDCarRentalSystem.Product.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleInventiryManagerImpl implements VehicleInventoryManager{

    private List<Vehicle> vehicles = new ArrayList<>();

    @Override
    public void addVehicle(Vehicle vehicle) {
        // add
    }

    @Override
    public void removeVehicle(String vehicleId) {
        // remove
    }

    @Override
    public List<Vehicle> listVehicles() {
        return List.of();
    }
}
