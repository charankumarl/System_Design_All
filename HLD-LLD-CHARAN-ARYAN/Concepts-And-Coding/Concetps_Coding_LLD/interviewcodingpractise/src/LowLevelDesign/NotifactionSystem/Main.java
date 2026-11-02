package LowLevelDesign.NotifactionSystem;

import LowLevelDesign.NotifactionSystem.coreClass.Notification;
import LowLevelDesign.NotifactionSystem.enums.Notification_Type;
import LowLevelDesign.NotifactionSystem.service.NotificationService;
import LowLevelDesign.NotifactionSystem.stratergy.Email;
import LowLevelDesign.NotifactionSystem.stratergy.Notification_Sender;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        NotificationService notificationService = new NotificationService();

        Notification email = new Notification(1, 1, "Welcome to our service!", Notification_Type.EMAIL);
        Notification SMS = new Notification(2, 1, "Welcome to our service!", Notification_Type.SMS);

        notificationService.send(email);
        notificationService.send(SMS);

        notificationService.shutdown();
    }
}
