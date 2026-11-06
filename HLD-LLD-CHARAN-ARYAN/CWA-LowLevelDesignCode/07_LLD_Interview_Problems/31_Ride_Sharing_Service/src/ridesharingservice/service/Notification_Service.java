package ridesharingservice.service;

import ridesharingservice.entities.Driver;
import ridesharingservice.entities.Trip;
import ridesharingservice.enums.Event;
import ridesharingservice.enums.Notification_Type;
import ridesharingservice.observer.*;

public class Notification_Service {

    Observer driverObserver = new Driver_Observer();
    Observer RiderObserver = new Rider_Observer();

    public void sendNotificationToDriver(Driver driver, Event event, String message) {

        for (Notification_Type type : driver.getOptedChannels()) {

            if(type == Notification_Type.EMAIL){
                sendEmailNotification(driver.getEmail(), event, message, driverObserver);
            }
            else if(type == Notification_Type.SMS) {
                sendSmsNotification(driver.getContact(), event, message, driverObserver);
            }
        }
    }

    public void sendNotificationToRider(Rider rider, Event event, String message) {

        for (Notification_Type type : rider.getOptedChannels()) {

            if(type == Notification_Type.EMAIL){
                sendEmailNotification(rider.getEmail(), event, message, RiderObserver);
            }
            else if(type == Notification_Type.SMS) {
                sendSmsNotification(rider.getContact(), event, message, RiderObserver);
            }
        }
    }

    public void sendNotificationToTrip(Trip trip, Event event, String message) {

        for (Notification_Type type : trip.getRider().getOptedChannels()) {

            if(type == Notification_Type.EMAIL){
                sendEmailNotification(trip.getRider().getEmail(), event, message, RiderObserver);
            }
            else if(type == Notification_Type.SMS) {
                sendSmsNotification(trip.getRider().getContact(), event, message, RiderObserver);
            }
        }

        for (Notification_Type type : trip.getDriver().getOptedChannels()) {

            if(type == Notification_Type.EMAIL){
                sendEmailNotification(trip.getDriver().getEmail(), event, message, driverObserver);
            }
            else if(type == Notification_Type.SMS) {
                sendSmsNotification(trip.getDriver().getContact(), event, message, driverObserver);
            }
        }
    }

    public void sendEmailNotification(String email, Event event, String message, Observer observer) {

        observer.onEmailUpdate(email, event, message);
    }

    public void sendSmsNotification(String sms, Event event, String message, Observer observer) {

        observer.onSmsUpdate(sms, event, message);
    }
}
