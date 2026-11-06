package ridesharingservice.entities;

import ridesharingservice.enums.DriverStatus;
import ridesharingservice.enums.Notification_Type;
import ridesharingservice.enums.TripStatus;
import ridesharingservice.observer.Email_Notification;
import ridesharingservice.observer.Notification_Channel;
import ridesharingservice.observer.Sms_Notification;

import java.util.ArrayList;
import java.util.List;

public class Driver extends User {
    private Vehicle vehicle;
    private Location currentLocation;
    private DriverStatus status;
    List<Notification_Type> optedChannels = List.of(Notification_Type.EMAIL, Notification_Type.SMS);

    public Driver(String name, String contact, Vehicle vehicle, Location initialLocation) {
        super(name, contact);
        this.vehicle = vehicle;
        this.currentLocation = initialLocation;
        this.status = DriverStatus.OFFLINE; // Default status
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public DriverStatus getStatus() {
        return status;
    }

    public void setStatus(DriverStatus status) {
        this.status = status;
        System.out.println("Driver " + getName() + " is now " + status);
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    @Override public void onUpdate(Trip trip) {
        System.out.printf("--- Notification for Driver %s ---\n", getName());
        System.out.printf("  Trip %s status: %s.\n", trip.getId(), trip.getStatus());
        if (trip.getStatus() == TripStatus.REQUESTED) {
            System.out.println("  A new ride is available for you to accept.");
        }
        System.out.println("--------------------------------\n");
    }

    public List<Notification_Type> getOptedChannels() {
        return optedChannels;
    }
}
