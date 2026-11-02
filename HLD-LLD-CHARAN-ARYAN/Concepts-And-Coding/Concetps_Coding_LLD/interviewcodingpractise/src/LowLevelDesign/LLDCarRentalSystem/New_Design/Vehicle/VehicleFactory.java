package LowLevelDesign.LLDCarRentalSystem.New_Design.Vehicle;

import LowLevelDesign.LLDCarRentalSystem.New_Design.Enum.VehicleType;

public class VehicleFactory {

    public static Vehicle createVehicle(VehicleType type,
                                        String registrationNumber, String model, double baseRentalPrice) {
        switch (type) {
            case BIKE:
                return new BikeVehicle(
                        registrationNumber, model, type, baseRentalPrice);
            case AUTO:
                return new AutoVehicle(
                        registrationNumber, model,type, baseRentalPrice);
            default:
                throw new IllegalArgumentException(
                        "Unsupported vehicle type: " + type);
        }
    }
}
