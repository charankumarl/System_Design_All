package LowLevelDesign.LLDCarRentalSystem.New_Design.RentalStore;

import LowLevelDesign.LLDCarRentalSystem.New_Design.Enum.VehicleStatus;
import LowLevelDesign.LLDCarRentalSystem.New_Design.Location.Location;
import LowLevelDesign.LLDCarRentalSystem.New_Design.Vehicle.Vehicle;

import java.util.*;

public class RentalStore {

    private int id;
    private String name;
    private Location location;
    private Map<String, Vehicle> vehicles; // Registration Number (Key) -> Vehicle (Value)

    public RentalStore(int id, String name, Location location) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.vehicles = new HashMap<>();
    }

    public List<Vehicle> getAvailableVehicles(Date startDate, Date endDate) {
        List<Vehicle> availableVehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicles.values()) {
            if (vehicle.getStatus() == VehicleStatus.AVAILABLE) {
                availableVehicles.add(vehicle);
            }
        }
        return availableVehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.put(vehicle.getRegistrationNumber(), vehicle);
    }

    public void removeVehicle(String registrationNumber) {
        vehicles.remove(registrationNumber);
    }

    public boolean isVehicleAvailable(
            String registrationNumber, Date startDate, Date endDate) {
        Vehicle vehicle = vehicles.get(registrationNumber);
        return vehicle != null
                && vehicle.getStatus() == VehicleStatus.AVAILABLE;
    }

    public Vehicle getVehicle(String registrationNumber) {
        return vehicles.get(registrationNumber);
    }

    public int getId() {
        return id;
    }
    // Getters and setters can be defined here
}
