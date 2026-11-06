package ridesharingservice.observer;

public class Sms_Notification implements Notification_Channel {

    @Override
    public void send(String phone, String message) {
        System.out.println("Sending SMS with Message: " + message);
    }
}
