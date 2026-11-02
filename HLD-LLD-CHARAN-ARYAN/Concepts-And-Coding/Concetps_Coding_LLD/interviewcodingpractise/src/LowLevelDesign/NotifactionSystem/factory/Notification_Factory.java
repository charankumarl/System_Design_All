package LowLevelDesign.NotifactionSystem.factory;

import LowLevelDesign.NotifactionSystem.enums.Notification_Type;
import LowLevelDesign.NotifactionSystem.stratergy.Email;
import LowLevelDesign.NotifactionSystem.stratergy.Notification_Sender;
import LowLevelDesign.NotifactionSystem.stratergy.SMS;

import java.util.HashMap;
import java.util.Map;

public class Notification_Factory {

    private static final Map<Notification_Type, Notification_Sender> senders = new HashMap<>();

    static{
        senders.put(Notification_Type.SMS, new SMS());
        senders.put(Notification_Type.EMAIL, new Email());
    }

    public static Notification_Sender getSender(Notification_Type type){
        return senders.get(type);
    }
}
