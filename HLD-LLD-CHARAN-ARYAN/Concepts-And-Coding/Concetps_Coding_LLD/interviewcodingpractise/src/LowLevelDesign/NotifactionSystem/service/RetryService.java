package LowLevelDesign.NotifactionSystem.service;

import LowLevelDesign.NotifactionSystem.coreClass.Notification;
import LowLevelDesign.NotifactionSystem.stratergy.Notification_Sender;

public class RetryService {

    private static final int MAX_RETRY_COUNT = 3;

    public static void Retry(Notification notification, Notification_Sender sender){

        for (int i = 0; i < MAX_RETRY_COUNT; i++) {

            try{
                sender.send(notification);
                return;
            }
            catch (Exception e){
                System.out.println("Initial send failed for User ID: " + notification.getUserId() + ". Retrying...");
            }
        }

        System.out.println("Failed to send notification to User ID: " + notification.getUserId() + " after " + MAX_RETRY_COUNT + " attempts.");
    }
}
