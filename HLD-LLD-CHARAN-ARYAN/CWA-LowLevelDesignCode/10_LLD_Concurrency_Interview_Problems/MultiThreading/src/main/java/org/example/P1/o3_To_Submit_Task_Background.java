package org.example.P1;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class o3_To_Submit_Task_Background {

    ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    AtomicInteger atomicInteger = new AtomicInteger(0);

    public CompletableFuture<Integer> voidReturn(){

        return CompletableFuture.supplyAsync(() -> {         ///  supply async for return value

            return atomicInteger.incrementAndGet();
        }, executorService);    /// all task are submitted to background threads.
    }

    public static void main(String[] args) {


    }
}
