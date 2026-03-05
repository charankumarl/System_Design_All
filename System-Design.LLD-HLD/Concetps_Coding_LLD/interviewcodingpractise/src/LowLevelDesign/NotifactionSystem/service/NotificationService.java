package LowLevelDesign.NotifactionSystem.service;

import LowLevelDesign.NotifactionSystem.coreClass.Notification;

public class NotificationService {

    Dispatcher dispatcher;

    public NotificationService() {
        this.dispatcher = new Dispatcher();
    }

    public void send(Notification notification){
        dispatcher.dispatch(notification);
    }

    public void shutdown(){
        dispatcher.shutdown();
    }
}
