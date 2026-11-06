package notification.concrete;

import notification.LibraryObserver;

public class SmsNotificationObserver implements LibraryObserver {
    @Override
    public void update(String message) {
        System.out.println("[SMS] " + message);
    }
}
