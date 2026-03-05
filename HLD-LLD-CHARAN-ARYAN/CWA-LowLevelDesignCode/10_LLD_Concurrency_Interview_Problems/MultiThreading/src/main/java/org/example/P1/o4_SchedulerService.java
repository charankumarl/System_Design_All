package org.example.P1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class o4_SchedulerService {

    ///  scheduler

    ScheduledExecutorService schduler = Executors.newScheduledThreadPool(2);

    public void scheduleTask(){

        schduler.scheduleAtFixedRate(() -> {

            System.out.println("Scheduled Task executed at: " + System.currentTimeMillis());

        }, 1, 10, TimeUnit.SECONDS);   /// Initial delay, period, time unit
    }



    public void scheduleTask1(){

        schduler.scheduleWithFixedDelay(() -> {       /// after completed, wait for delay, then runs.

            System.out.println("Scheduled Task executed at: " + System.currentTimeMillis());

        }, 1, 10, TimeUnit.SECONDS);   /// Initial delay, delay / wait for this time after completes, time unit
    }


    public static void main(String[] args) {

    }
}
