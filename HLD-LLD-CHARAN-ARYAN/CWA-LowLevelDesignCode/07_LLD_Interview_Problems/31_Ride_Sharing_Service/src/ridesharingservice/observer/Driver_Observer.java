package ridesharingservice.observer;

import ridesharingservice.entities.Driver;
import ridesharingservice.entities.Trip;
import ridesharingservice.enums.Event;
import ridesharingservice.enums.Notification_Type;

import java.util.ArrayList;
import java.util.List;

public class Driver_Observer implements Observer {

    Notification_Channel email_notification_channel = new Email_Notification();
    Notification_Channel sms_notification_channel = new Sms_Notification();

    @Override
    public void onEmailUpdate(String email, Event event, String message) {
        email_notification_channel.send(email, message);
    }

    @Override
    public void onSmsUpdate(String sms, Event event, String message) {
        sms_notification_channel.send(sms, message);
    }
}
