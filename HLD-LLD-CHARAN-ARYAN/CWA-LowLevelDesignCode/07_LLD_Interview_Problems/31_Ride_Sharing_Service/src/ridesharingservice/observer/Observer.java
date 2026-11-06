package ridesharingservice.observer;

import ridesharingservice.entities.Driver;
import ridesharingservice.entities.Trip;
import ridesharingservice.enums.Event;

public interface Observer {

    void onEmailUpdate(String email, Event event, String message);

    void onSmsUpdate(String sms, Event event, String message);
}
