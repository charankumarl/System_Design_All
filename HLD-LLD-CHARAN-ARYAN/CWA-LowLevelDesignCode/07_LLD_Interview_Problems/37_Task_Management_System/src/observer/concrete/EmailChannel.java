package observer.concrete;

import observer.TaskObserver;

public class EmailChannel implements TaskObserver {
    private final String email;

    public EmailChannel(String email) {
        this.email = email;
    }

    @Override
    public void update(String change) {
        System.out.println("[EMAIL] to " + email + ": " + change);
    }
}
