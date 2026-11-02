package LowLevelDesign.NotifactionSystem.stratergy;

import LowLevelDesign.NotifactionSystem.coreClass.Notification;

public class Email implements Notification_Sender {

    @Override
    public void send(Notification notification) {
        System.out.println("Sending EMAIL to User ID: " + notification.getUserId() + " with Message: " + notification.getMessage());
    }
}
