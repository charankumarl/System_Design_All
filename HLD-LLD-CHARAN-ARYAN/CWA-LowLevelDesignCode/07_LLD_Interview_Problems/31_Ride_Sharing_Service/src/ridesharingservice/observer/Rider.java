package ridesharingservice.observer;

import ridesharingservice.entities.Trip;
import ridesharingservice.entities.User;
import ridesharingservice.enums.Notification_Type;

import java.util.List;

public class Rider extends User {
    List<Notification_Type> optedChannels = List.of(Notification_Type.EMAIL, Notification_Type.SMS);

    public Rider(String name, String contact) {
        super(name, contact);
    }

    @Override
    public void onUpdate(Trip trip) {
        System.out.printf("--- Notification for Rider %s ---\n", getName());
        System.out.printf("  Trip %s is now %s.\n", trip.getId(), trip.getStatus());
        if (trip.getDriver() != null) {
            System.out.printf("  Driver: %s in a %s (%s)\n",
                    trip.getDriver().getName(), trip.getDriver().getVehicle().getModel(),
                    trip.getDriver().getVehicle().getLicenseNumber());
        }
        System.out.println("--------------------------------\n");
    }

    public List<Notification_Type> getOptedChannels() {
        return optedChannels;
    }
}