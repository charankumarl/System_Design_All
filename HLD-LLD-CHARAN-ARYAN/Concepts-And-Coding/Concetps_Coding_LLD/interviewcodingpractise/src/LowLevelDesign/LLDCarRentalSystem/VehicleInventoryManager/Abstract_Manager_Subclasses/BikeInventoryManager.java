package LowLevelDesign.LLDCarRentalSystem.VehicleInventoryManager.Abstract_Manager_Subclasses;

import LowLevelDesign.LLDCarRentalSystem.Product.Bike;

public class BikeInventoryManager extends VehicleInventoryManager<Bike>{

    public BikeInventoryManager() {
        super();
    }

    @Override
    public void addVehicle(Bike bike) {
        super.addVehicle(bike);
    }

    @Override
    public void removeVehicle(String vehicleId) {
        super.removeVehicle(vehicleId);
    }

}
