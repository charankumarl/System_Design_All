package org.example.P1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class o2_Same_With_Return {

    ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * If we have ANY  return type, then we use SUPPLY ASYNC()
     */
    public CompletableFuture<Integer> voidReturn(){

        return CompletableFuture.supplyAsync(() -> {         ///  supply async for return value

            return atomicInteger.incrementAndGet();
        }, executorService);
    }

    ///  ShutDown executor

    void shutdown() throws InterruptedException {
        executorService.shutdown();

        if(executorService.awaitTermination(1, TimeUnit.SECONDS)){
            executorService.shutdownNow();
        }

        executorService.shutdown();
    }

    public static void main(String[] args) {

        o2_Same_With_Return test = new o2_Same_With_Return();

        List<CompletableFuture<Integer>> futures = new ArrayList<>();

        futures.add(test.voidReturn());
        futures.add(test.voidReturn());
        futures.add(test.voidReturn());    ///1. Submitted all tasks

        ///  2. Convert to Array to get output.

        CompletableFuture<Void> all = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        /// 3. To make Thread Wait until we get result.

        //all.join();

        /// 4. To print all data.
        for(CompletableFuture<Integer> f : futures){
            System.out.println(f.join());     /// here we print everything
        }


        ///  5. To skip the main thread waiting.

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).thenRun( () -> {
            for(CompletableFuture<Integer> f : futures){
                System.out.println(f.join());
            }
        });

        System.out.println("main thread ended");

    }
}
