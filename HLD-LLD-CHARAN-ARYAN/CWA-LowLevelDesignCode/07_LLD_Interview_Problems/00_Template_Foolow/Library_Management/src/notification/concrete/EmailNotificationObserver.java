package notification.concrete;

import notification.LibraryObserver;

public class EmailNotificationObserver implements LibraryObserver {
    @Override
    public void update(String message) {
        System.out.println("[EMAIL] " + message);
    }
}
