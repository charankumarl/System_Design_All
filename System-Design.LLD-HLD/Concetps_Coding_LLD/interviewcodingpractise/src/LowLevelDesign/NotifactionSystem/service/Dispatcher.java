package LowLevelDesign.NotifactionSystem.service;

import LowLevelDesign.NotifactionSystem.coreClass.Notification;
import LowLevelDesign.NotifactionSystem.factory.Notification_Factory;
import LowLevelDesign.NotifactionSystem.stratergy.Notification_Sender;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Dispatcher {

    Notification_Sender sender;

    int availableCores = Runtime.getRuntime().availableProcessors();
    int threadCount = Math.min(availableCores * 2, 8);
    private final ExecutorService executorService = Executors.newFixedThreadPool(threadCount);

    public void dispatch(Notification notification){

        executorService.submit(() -> {

            try{
                this.sender = Notification_Factory.getSender(notification.getType());
                sender.send(notification);
            }
            catch (Exception e){

                RetryService.Retry(notification, sender);
            }
        });
    }

    public void shutdown(){
        executorService.shutdown();

        try {
            if(!executorService.awaitTermination(1, TimeUnit.SECONDS)){
                executorService.shutdownNow();
            }
        }
        catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
