package LowLevelDesign.LLDCarRentalSystem.New_Design.Vehicle;

import LowLevelDesign.LLDCarRentalSystem.New_Design.Enum.VehicleType;

public class AutoVehicle extends Vehicle {

    private static final double RATE_MULTIPLIER = 1.2;

    public AutoVehicle(
            String registrationNumber, String model, VehicleType type, double baseRentalPrice) {
        super(registrationNumber, model, type, baseRentalPrice);
    }

    @Override
    public double calculateRentalFee(int days) {
        return getBaseRentalPrice() * days * RATE_MULTIPLIER;
    }
}