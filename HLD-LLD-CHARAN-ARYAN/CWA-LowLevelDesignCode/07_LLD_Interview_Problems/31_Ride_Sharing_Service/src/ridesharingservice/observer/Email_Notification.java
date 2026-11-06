package ridesharingservice.observer;

public class Email_Notification implements Notification_Channel {
    @Override
    public void send(String email, String message) {
        System.out.println("Sending Email with Message: " + message);
    }
}
