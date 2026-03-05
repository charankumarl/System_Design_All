package LowLevelDesign.NotifactionSystem.stratergy;

import LowLevelDesign.NotifactionSystem.coreClass.Notification;

public class SMS implements Notification_Sender {

    @Override
    public void send(Notification notification) {
        System.out.println("Sending SMS to User ID: " + notification.getUserId() + " with Message: " + notification.getMessage());
    }
}
