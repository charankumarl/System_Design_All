package LowLevelDesign.NotifactionSystem.coreClass;

import LowLevelDesign.NotifactionSystem.enums.Notification_Type;

public class Notification {

    int id;
    int userId;
    String message;
    Notification_Type type;

    public Notification(int id, int userId, String message, Notification_Type type) {
        this.id = id;
        this.userId = userId;
        this.message = message;
        this.type = type;
    }

    public Notification_Type getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }
}
